
package com.example.MessageBoard;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	

    // private List<Message> messages  = new ArrayList<>();
    // private long msgId = 0;  
     
    @Autowired
    MessageRepository messagerepository;

    public List<Message> getMessages(){
        return messagerepository.findAll();
    }

    public void addMessage(Message message){
        messagerepository.save(message);
    }
    
    public Message getMessageId(long msgId){
         return messagerepository.findById(msgId).orElse(null);
    }

    public void updateMessage(long msgId, Message updMessage){
         Message existingmess = messagerepository.findById(msgId).orElse(null);

         if(existingmess != null){
            existingmess.setMessage(updMessage.getMessage());
            messagerepository.save(existingmess);
         }
    }
   
    public void deleteMessage(long msgId){
       messagerepository.deleteById(msgId);
    }


}
