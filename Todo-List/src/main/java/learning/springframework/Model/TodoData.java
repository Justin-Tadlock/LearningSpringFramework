package learning.springframework.Model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {
  private static int idValue = 1;
  
  private final List<TodoItem> items = new ArrayList<>();
  
  public TodoData() {
    addExampleData();
  }
  
  private void addExampleData() {
    addItem(new TodoItem("firstExampleTitle", "First example details", LocalDate.now()));
    addItem(new TodoItem("secondExampleTitle", "Second example details", LocalDate.now()));
    addItem(new TodoItem("thirdExampleTitle", "Third example details", LocalDate.now()));
    addItem(new TodoItem("fourthExampleTitle", "Fourth example details", LocalDate.now()));
  }
  
  public List<TodoItem> getItems() {
    return Collections.unmodifiableList(items);
  }
  
  @NonNull
  public void addItem(TodoItem item) {
    item.setId(idValue);
    items.add(item);
    idValue++;
  }
  
  public void removeItem(int id) {
    ListIterator<TodoItem> itemIT = items.listIterator();
    
    while(itemIT.hasNext()) {
      if(itemIT.next().getId() == id) {
        itemIT.remove();
      }
    }
  }
  
  public TodoItem getItem(int id) {
    for(TodoItem item : items) {
      if(item.getId() == id) {
        return item;
      }
    }
    
    return null;
  }
  
  public void updateItem(@NonNull TodoItem updatedItem) {
    ListIterator<TodoItem> itemIT = items.listIterator();
    
    while(itemIT.hasNext()) {
      if(itemIT.next().equals(updatedItem)) {
        itemIT.set(updatedItem);
        break;
      }
    }
  }
}
