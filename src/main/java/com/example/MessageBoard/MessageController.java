package com.example.MessageBoard;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageboard")
public class MessageController {
    
@Autowired
private MessageService messageservice;
 
@GetMapping("/messages")
public List<Message> getMessages(){
    return messageservice.getMessages();
}


@PostMapping
public void addMessage(@RequestBody Message message){
   messageservice.addMessage(message);
}

@PutMapping("/{msgId}")
public void updateMessage(@RequestBody Message message, @PathVariable Long msgId) {
    messageservice.updateMessage(msgId, message);
}


@GetMapping("getmessageId/{msgId}")
  public Message getMessageId(@PathVariable Long msgId){
    
    return messageservice.getMessageId(msgId);
    
  }

@DeleteMapping("/{msgId}")
public void deleteMessage(@PathVariable Long msgId) {
    messageservice.deleteMessage(msgId);
}

}