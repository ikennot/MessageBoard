package com.example.MessageBoard;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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


}
