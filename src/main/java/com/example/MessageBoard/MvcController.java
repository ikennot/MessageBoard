package com.example.MessageBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messageboardweb")
public class MvcController {
    
    @GetMapping("/index")
public String showIndex(){
  return "index";
}

@GetMapping("/AddMessage")
public String messageForm(){
    return "form";
}
}
