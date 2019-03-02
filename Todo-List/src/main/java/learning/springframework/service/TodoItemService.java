package learning.springframework.service;

import learning.springframework.Model.TodoData;
import learning.springframework.Model.TodoItem;

public interface TodoItemService {
  public void addItem(TodoItem item);
  public void removeItem(int id);
  public TodoItem getItem(int id);
  public void updateItem(TodoItem updatedItem);
  public TodoData getData();
}
