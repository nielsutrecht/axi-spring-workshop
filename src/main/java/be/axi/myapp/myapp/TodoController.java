package be.axi.myapp.myapp;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public Todo createTodo(@RequestBody TodoCreateRequest request) {
        return service.create(
            request.title,
            request.description,
            request.completeBy
        );
    }

    @GetMapping()
    public TodoListResponse getAll() {
        return new TodoListResponse(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable int id) {
        var result =  service.findById(id);

        return ResponseEntity.of(result);
    }

    @PutMapping("/{id}")
    public Todo update(@RequestBody TodoUpdateRequest request, @PathVariable  int id) {
        return service.update(
            id,
            request.title,
            request.description,
            request.completeBy,
            request.completedOn
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);

        return ResponseEntity.accepted().build();
    }

    @Data
    private static class TodoListResponse {
        private final List<Todo> todos;
    }

    @Data
    private static class TodoCreateRequest {
        private String title;
        private String description;
        private String completeBy;
    }

    @Data
    private static class TodoUpdateRequest {
        private String title;
        private String description;
        private String completeBy;
        private String completedOn;
    }
}
