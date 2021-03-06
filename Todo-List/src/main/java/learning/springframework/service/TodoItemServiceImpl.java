package learning.springframework.service;

import learning.springframework.Model.TodoData;
import learning.springframework.Model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {
  
  @Getter
  private final TodoData data = new TodoData();
  
  @Override
  public void addItem(TodoItem item) {
    data.addItem(item);
  }
  
  @Override
  public void removeItem(int id) {
    data.removeItem(id);
  }
  
  @Override
  public TodoItem getItem(int id) {
    return data.getItem(id);
  }
  
  @Override
  public void updateItem(TodoItem updatedItem) {
    data.updateItem(updatedItem);
  }
}
