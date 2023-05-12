package com.example.postservice.repository;

import com.example.postservice.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {



    Page<Message> findByFromUsernameEqualsIgnoreCaseAndToUsernameEqualsIgnoreCase(String fromUsername,
                                                                                  String toUsername,
                                                                                  Pageable pageable);
    @Query("""
            {
            
            "fromUsername": { "$in":[ ?0, ?1 ] },
            "toUsername": { "$in": [ ?1, ?0]}
            
            }
            """
            )
    Page<Message> findMessages(@Param("fromUsername") String fromUsername, @Param("toUsername") String toUsername, Pageable pageable);

}
