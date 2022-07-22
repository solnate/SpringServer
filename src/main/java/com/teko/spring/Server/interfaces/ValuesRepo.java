package com.teko.spring.Server.interfaces;

import com.teko.spring.Server.entity.Transfer;
import com.teko.spring.Server.entity.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuesRepo extends MongoRepository<Value, Integer> {
    Value findValueBy_id(@Param("_id") int _id);
}