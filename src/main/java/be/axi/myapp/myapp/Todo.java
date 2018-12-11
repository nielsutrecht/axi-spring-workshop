package be.axi.myapp.myapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private int id;
    private String title;
    private String description;
    private String completeBy;
    private String completedOn;
}
