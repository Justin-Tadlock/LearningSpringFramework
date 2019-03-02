package learning.springframework.Model;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {
  private int id;
  private String title;
  private String detail;
  private LocalDate date;
  
  public TodoItem(String title, String detail, LocalDate date) {
    this.title = title;
    this.detail = detail;
    this.date = date;
  }
}
