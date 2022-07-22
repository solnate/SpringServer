package com.teko.spring.Server.interfaces;

import com.teko.spring.Server.entity.Transfer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepo extends MongoRepository<Transfer, String> {
    Transfer findTransferById(@Param("id") String id);

    @Query(value = "{'tx._id': ?0}")
    Transfer findTransferByTxId(String id);
}
