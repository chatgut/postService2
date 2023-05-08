package com.example.postservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "messages")
public class Message {

    public Message() {}

    public Message(String id, String fromUsername, String toUsername, String message, String dateAndTime) {
        this.id = id;
        this.fromUsername = fromUsername;
        this.toUsername = toUsername;
        this.message = message;
        this.dateAndTime = dateAndTime;
    }

    @Id
    private String id;

    private String fromUsername;
    private String toUsername;

    private String message;

    private String dateAndTime;

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", fromUsername='" + fromUsername + '\'' +
                ", toUsername='" + toUsername + '\'' +
                ", message='" + message + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                '}';
    }
}
