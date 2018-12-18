package be.axi.myapp.myapp;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties
@Getter
public class GreetingConfiguration {
    private List<String> greetings = new ArrayList<>();
}
