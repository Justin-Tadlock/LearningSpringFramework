package learning.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ViewResolver;

@Controller
public class DemoController {
  
  @ResponseBody
  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
  
  @GetMapping("welcome")
  public String welcome() {
    return "Welcome";
  }
}
