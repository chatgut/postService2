package com.example.postservice.controller;

import com.example.postservice.model.Message;
import com.example.postservice.repository.MessageRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/createmessage")
    public Message createMessage(@RequestBody Message message) {
        message.setDateAndTime(LocalDateTime.now().toString());
        return repository.save(message);
    }


    @GetMapping("/getmessages")
    public List<Message> getMessages(@RequestParam String fromUsername,
                                     @RequestParam String toUsername,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int nMessages) {
        Pageable paging = PageRequest.of(page, nMessages);
//        List<Message> from = repository.findByFromUsernameEqualsIgnoreCase(fromUsername, paging).getContent();
//        List<Message> to = repository.findByToUsernameEqualsIgnoreCase(toUsername, paging).getContent();
        List<Message> fromandto = repository.findByFromUsernameEqualsIgnoreCaseAndToUsernameEqualsIgnoreCase(
                fromUsername, toUsername, paging).getContent();
        return fromandto;

    }

}