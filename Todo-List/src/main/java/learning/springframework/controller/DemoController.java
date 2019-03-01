package learning.springframework.controller;

import learning.springframework.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
  
  private final DemoService demoService;
  
  // Constructors
  @Autowired
  public DemoController(DemoService demoService) {
    this.demoService = demoService;
  }
  
  // Request methods
  @ResponseBody
  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
  
  @GetMapping("welcome")
  public String welcome(Model model) {
    model.addAttribute("message", demoService.getHelloMessage("Bitch"));
    
    return "welcome";
  }
  
  // Model Attributes
  @ModelAttribute("welcomeMessage")
  public String welcomeMessage() {
    return "Welcome to MAXIMUM RAWRING!";
  }
}
