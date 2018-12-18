package be.axi.myapp.myapp;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class GreetingRepository {
    private final List<String> greetings;

    public GreetingRepository(GreetingConfiguration config) {
        this.greetings = Collections.unmodifiableList(config.getGreetings());
    }

    public List<String> getGreetings() {
        return greetings;
    }

    public int countGreetings() {
        return greetings.size();
    }
}
