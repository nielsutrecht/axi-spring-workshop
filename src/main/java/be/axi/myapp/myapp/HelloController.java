package be.axi.myapp.myapp;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${myapp.message}")
    private String message;

    @GetMapping("/hello")
    public HelloResponse hello() {
        var response = new HelloResponse(message);

        return response;
    }

    @Data
    static class HelloResponse {
        private final String message;
    }
}
