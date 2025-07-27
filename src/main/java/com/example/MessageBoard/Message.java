package com.example.MessageBoard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Message{
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long msgId;
    private String name;
    private String message;


    public Message(){
        
    }

   public Message(long msgId,String name,String message){
     this.msgId = msgId;
     this.name = name;
     this.message = message;
   }
    public long getMsgId() {
        return msgId;
    }


    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


}