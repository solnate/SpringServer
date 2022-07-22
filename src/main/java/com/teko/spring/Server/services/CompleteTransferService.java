package com.teko.spring.Server.services;

import com.teko.spring.Server.entity.CompleteTransfer;
import com.teko.spring.Server.entity.Transfer;
import com.teko.spring.Server.interfaces.CompleteTransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompleteTransferService {
    @Autowired
    private CompleteTransferRepo completeTransferRepo;

    public void addTransfer(CompleteTransfer newTransfer) throws Exception {
        if(completeTransferRepo.findTransferById(newTransfer.getTx().getId()) == null){
            completeTransferRepo.save(newTransfer);
        }
        else{
            throw new Exception("already exists");
        }
    }

    public CompleteTransfer getTransfer(String id) throws Exception {
        CompleteTransfer transfer = completeTransferRepo.findTransferById(id);
        if(transfer != null){
            return transfer;
        }
        else{
            throw new Exception("not found transfer");
        }
    }

}
