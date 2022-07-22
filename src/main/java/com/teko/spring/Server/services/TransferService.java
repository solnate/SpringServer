package com.teko.spring.Server.services;

import com.teko.spring.Server.entity.Transfer;
import com.teko.spring.Server.interfaces.TransferRepo;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired
    private TransferRepo transferRepo;

    public void addTransfer(Transfer newTransfer) throws Exception {
        if(transferRepo.findTransferByTxId(newTransfer.getTx().getId()) == null){
            transferRepo.save(newTransfer);
        }
        else{
            throw new Exception("already exists");
        }
    }

    public Transfer getTransfer(String id) throws Exception {
        Transfer transfer = transferRepo.findTransferById(id);
        if(transfer != null){
            return transfer;
        }
        else{
            throw new Exception("nof found transfer");
        }
    }

    public void deleteTransfer(Transfer transfer) throws Exception {
        if(transfer != null){
            transferRepo.delete(transfer);
        }
        else{
            throw new Exception("nof found transfer");
        }
    }

    public String GeneratingRandomString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
