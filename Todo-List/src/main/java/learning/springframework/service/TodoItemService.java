package learning.springframework.service;

import learning.springframework.Model.TodoData;
import learning.springframework.Model.TodoItem;

public interface TodoItemService {
  void addItem(TodoItem item);
  void removeItem(int id);
  TodoItem getItem(int id);
  void updateItem(TodoItem updatedItem);
  TodoData getData();
}
