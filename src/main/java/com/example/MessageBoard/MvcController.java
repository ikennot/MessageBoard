package com.example.MessageBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messageboardweb")
public class MvcController {
    
  @Autowired
   private MessageService service;

  @GetMapping("/index")
   public String showIndex(Model model){
    model.addAttribute("message",service.getMessages());
    return "index";
  }

  @GetMapping("/AddMessage")
  public String messageForm(Model model){
    model.addAttribute("message",new Message());
    return "form";
  }

  
  @PostMapping("/addnewmessage")
   public String addnewMessage(@ModelAttribute Message message,Model model){
    service.addMessage(message);
  return "redirect:/messageboardweb/index"; // redirect para maiwasan ang double-submit
   }

}
