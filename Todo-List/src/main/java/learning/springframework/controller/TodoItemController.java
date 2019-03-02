package learning.springframework.controller;

import learning.springframework.Model.TodoData;
import learning.springframework.service.TodoItemServiceImpl;
import learning.springframework.util.Mappings;
import learning.springframework.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {
  
  private final TodoItemServiceImpl todoItemService;
  
  @Autowired
  public TodoItemController(TodoItemServiceImpl todoItemService) {
    this.todoItemService = todoItemService;
  }
  
  @ModelAttribute
  public TodoData todoData() {
    return todoItemService.getData();
  }
  
  @GetMapping(Mappings.ITEMS)
  public String items() {
    return ViewNames.ITEMS_LIST;
  }
  
  @GetMapping("addTodo")
  public String addTodo() {
    return "addItem";
  }
}
