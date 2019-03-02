package learning.springframework.service;

import learning.springframework.Model.TodoData;
import learning.springframework.Model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {
  
  private final TodoData todoData = new TodoData();
  
  @Override
  public void addItem(TodoItem item) {
    todoData.addItem(item);
  }
  
  @Override
  public void removeItem(int id) {
    todoData.removeItem(id);
  }
  
  @Override
  public TodoItem getItem(int id) {
    return todoData.getItem(id);
  }
  
  @Override
  public void updateItem(TodoItem updatedItem) {
    todoData.updateItem(updatedItem);
  }
  
  @Override
  public TodoData getData() {
    return todoData;
  }
}
