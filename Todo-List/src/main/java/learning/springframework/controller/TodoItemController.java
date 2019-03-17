package learning.springframework.controller;

import learning.springframework.Model.TodoData;
import learning.springframework.Model.TodoItem;
import learning.springframework.service.TodoItemServiceImpl;
import learning.springframework.util.AttributeNames;
import learning.springframework.util.Mappings;
import learning.springframework.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Slf4j
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
  
  @GetMapping(Mappings.ADD_ITEM)
  public String addEditItem(Model model) {
    TodoItem todoItem = new TodoItem("","", LocalDate.now());
    
    model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
    
    return ViewNames.ADD_ITEM;
  }
  
  @PostMapping(Mappings.ADD_ITEM)
  public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
    log.info("todoItem from form = {}", todoItem);
    
    todoItemService.addItem(todoItem);
    
    return "redirect:/" + Mappings.ITEMS;
  }
}
