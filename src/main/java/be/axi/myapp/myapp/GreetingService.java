package be.axi.myapp.myapp;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GreetingService {
    private final Random random = new Random();
    private final GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public String randomGreeting() {
        return repository.getGreetings().get(random.nextInt(repository.countGreetings()));
    }
}
