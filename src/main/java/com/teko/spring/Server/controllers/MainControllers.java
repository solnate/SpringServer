package com.teko.spring.Server.controllers;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.teko.spring.Server.entity.*;
import com.teko.spring.Server.interfaces.cancelPayment.CancelResult;
import com.teko.spring.Server.interfaces.cancelPayment.CancelSuccessResponse;
import com.teko.spring.Server.entity.isPaymentPossible.Result;
import com.teko.spring.Server.entity.isPaymentPossible.SuccessResponse;
import com.teko.spring.Server.handlers.ResponseHandler;
import com.teko.spring.Server.services.CompleteTransferService;
import com.teko.spring.Server.services.TransferService;
import com.teko.spring.Server.services.RestService;
import com.teko.spring.Server.services.ValuesService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainControllers {
    private final TransferService transferService;
    private final RestService restService;
    private final ValuesService valuesService;
    private final CompleteTransferService completeTransferService;

    public MainControllers(TransferService transferService, RestService restService, ValuesService valuesService, CompleteTransferService completeTransferService) {
        this.transferService = transferService;
        this.restService = restService;
        this.valuesService = valuesService;
        this.completeTransferService = completeTransferService;
    }

    @GetMapping("/initPayment")
    public ResponseEntity<Object> initPayment(){
        DefaultRequest req = new DefaultRequest(
                new Client("praktika_2022", "app"),
                "spotify",
                new Payment(10000, 643, 2),
                new Order("1122334455", 142843063,
                        "transaction", "mobile_app",  "some_value"),
                new Src("mc", "78005553535", "mts"),
                "Europe");

        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                return expose != null && !expose.serialize();
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        }).create();
        String json = gson.toJson(req);
        byte[] key = "TestSecret".getBytes();
        HmacUtils hm256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, key);
        String hmac = Base64.encodeBase64String(hm256.hmac(json));

        return this.restService.postReq(json, hmac);
    }

    @PostMapping("/isPaymentPossible")
    public ResponseEntity<Object> isPaymentPossible(@RequestBody DefaultRequest request){
        try {
            Transfer newTransfer = new Transfer(this.transferService.GeneratingRandomString(), request.getTx());
            if (this.valuesService.getValue(request.getPayment().getCurrency()) == null){
                this.valuesService.addValue(request.getPayment().getCurrency(), 0);
            }
            if (this.valuesService.getValue(request.getPayment().getCurrency()).getAmount() >
                    request.getPayment().getAmount()) {
                this.transferService.addTransfer(newTransfer);
                return ResponseHandler.generateResponse(
                        HttpStatus.OK,
                        new SuccessResponse("true", new Result(
                                request.getTx(),
                                request.getPayment(),
                                request.getRate())
                        )
                );
            }
            else{
                throw new Exception("insufficient values");
            }
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    new ErrorResponse("false", "402", e.getMessage())
            );
        }
    }

    @PostMapping("/resumePayment")
    public ResponseEntity<Object> resumePossible(@RequestBody DefaultRequest request){
        try {
            Transfer transfer = this.transferService.getTransfer(request.getPartner_tx().getId());
            int currency = request.getPayment().getCurrency();
            int amount = request.getPayment().getAmount();
            this.valuesService.updateValue(currency,
                    (this.valuesService.getValue(currency).getAmount() - amount)
            );

            int src_currency = request.getSrc_payment().getCurrency();
            int src_amount = request.getSrc_payment().getAmount();
            this.valuesService.updateValue(src_currency,
                    (this.valuesService.getValue(src_currency).getAmount() + src_amount)
            );
            this.completeTransferService.addTransfer(new CompleteTransfer(
                    request.getPartner_tx().getId(),
                    request.getTx(),
                    request.getPayment(),
                    request.getSrc_payment()
            ));
            this.transferService.deleteTransfer(transfer);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    new SuccessResponse("true", new Result(
                            request.getTx(),
                            request.getPayment(),
                            request.getRate())
                    )
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    new ErrorResponse("false", "402", e.getMessage())
            );
        }
    }

    @PostMapping("/cancelPayment")
    public ResponseEntity<Object> cancelPossible(@RequestBody DefaultRequest request) {
        try {
            Transfer transfer = this.transferService.getTransfer(request.getPartner_tx().getId());
            this.transferService.deleteTransfer(transfer);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    new CancelSuccessResponse("true", new CancelResult(request.getTx()))
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    new ErrorResponse("false", "402", e.getMessage())
            );
        }
    }


    @PostMapping("/add")
    public void addMoney(@RequestBody int _id) throws Exception {
        this.valuesService.addValue(_id, 20000);
    }
}
