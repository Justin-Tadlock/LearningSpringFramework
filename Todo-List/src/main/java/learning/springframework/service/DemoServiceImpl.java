package learning.springframework.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
  
  @Override
  public String getHelloMessage(String user) {
    return user;
  }
  
  @Override
  public String getWelcomeMessage() {
    return "Welcome to Stop Rawring";
  }
}
