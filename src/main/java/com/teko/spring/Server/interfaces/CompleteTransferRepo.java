package com.teko.spring.Server.interfaces;

import com.teko.spring.Server.entity.CompleteTransfer;
import com.teko.spring.Server.entity.Transfer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteTransferRepo extends MongoRepository<CompleteTransfer, String> {
    CompleteTransfer findTransferById(@Param("id") String id);

}
