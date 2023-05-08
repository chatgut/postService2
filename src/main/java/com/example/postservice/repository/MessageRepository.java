package com.example.postservice.repository;

import com.example.postservice.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    Page<Message> findByFromUsernameEqualsIgnoreCase(String fromUserName, Pageable pageable);
    Page<Message> findByFromUsernameEqualsIgnoreCaseAndToUsernameEqualsIgnoreCase(String fromUsername,
                                                                                  String toUsername,
                                                                                  Pageable pageable);
    Page<Message> findByToUsernameEqualsIgnoreCase(String toUserName, Pageable pageable);
}
