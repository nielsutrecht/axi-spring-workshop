package be.axi.myapp.myapp;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TodoService {
    private List<Todo> todoList = new ArrayList<>();
    private AtomicInteger nextId = new AtomicInteger();

    public List<Todo> findAll() {
        return todoList;
    }

    public Optional<Todo> findById(int id) {
        return todoList.stream().filter(t -> t.getId() == id).findFirst();
    }

    public Optional<Todo> findByTitle(String subString) {
        return todoList.stream().filter(t -> t.getTitle().contains(subString)).findFirst();
    }

    public Todo create(String title, String description, String completeBy) {
        Todo todo = new Todo(nextId.incrementAndGet(), title, description, completeBy, null);

        todoList.add(todo);

        return todo;
    }

    public Todo update(int id, String title, String description, String completeBy, String completedOn) {
        var todo = findById(id);

        if(!todo.isPresent()) {
            throw new IllegalArgumentException("No Todo with ID " + id);
        }

        todo.ifPresent(t -> {
            t.setTitle(title);
            t.setDescription(description);
            t.setCompleteBy(completeBy);
            t.setCompletedOn(completedOn);
        });

        return todo.get();
    }

    public void delete(int id) {
        todoList.removeIf(t -> t.getId() == id);
    }

    @PostConstruct
    public void init() {
        create("Create Basic Service", "Create a basic REST service", "2019-01-01");
        create("Implement Data Storage", "Add JPA so we can persist data", "2019-01-01");
    }
}
