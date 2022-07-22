package com.teko.spring.Server.services;

import com.teko.spring.Server.entity.Value;
import com.teko.spring.Server.interfaces.ValuesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValuesService {

    @Autowired
    private ValuesRepo valuesRepo;

    public Value getValue(int _id) throws Exception {
        try {
            return valuesRepo.findValueBy_id(_id);
        } catch(Exception e){
            throw new Exception("no value");
        }
    }
    public void addValue(int _id, int amount) throws Exception {
        try {
            valuesRepo.save(new Value(_id, amount));
        } catch(Exception e){
            throw new Exception("already values");
        }
    }
    public void updateValue(int _id, int amount) throws Exception {
        try {
            valuesRepo.save(new Value(_id, amount));
        } catch(Exception e){
            throw new Exception("already values");
        }
    }
}
