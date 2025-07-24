
package com.example.MessageBoard;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	

    private List<Message> messages  = new ArrayList<>();

    public List<Message> getMessages(){
        return messages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }
    
    public Message getMessageId(long msgId){
         for (Message message : messages) {
              if(message.getMsgId() == msgId)
                 return message;
         }

       return null;
    }

    public void updateMessage(long msgId, Message updMessage){
        for (Message message: messages){
            if(message.getMsgId() == msgId)
            {
            message.setMessage(updMessage.getMessage());
            }
        }
    }
   
    public void deleteMessage(long msgId){
        messages.remove(msgId);
    }


}
