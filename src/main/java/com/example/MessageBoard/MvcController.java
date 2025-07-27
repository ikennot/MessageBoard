package com.example.MessageBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messageboardweb")
public class MvcController {
    
  @Autowired
   private MessageService service;

  @GetMapping("/index")
   public String showIndex(Model model){
    model.addAttribute("formdata",service.getMessages());
    return "index";
  }

  @GetMapping("/AddMessage")
  public String messageForm(Model model){
    model.addAttribute("formdata",new Message());
    return "form";
  }

  
  @PostMapping("/addnewmessage")
   public String addnewMessage(@ModelAttribute("formdata") Message message,Model model){
    service.addMessage(message);
  return "redirect:/messageboardweb/index"; // redirect para maiwasan ang double-submit
   }



  @GetMapping("delete/{msgId}")
  public String deletemessage(@PathVariable long msgId){
      service.deleteMessage(msgId);
    return "redirect:/messageboardweb/index";
  }
}
