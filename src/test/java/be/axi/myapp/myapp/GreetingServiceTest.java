package be.axi.myapp.myapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GreetingServiceTest {
    private GreetingRepository repository;
    private GreetingService service;

    @Before
    public void setup() {
        repository = Mockito.mock(GreetingRepository.class);
        service = new GreetingService(repository);
    }

    @Test
    public void randomGreeting() {
        when(repository.countGreetings()).thenReturn(3);
        when(repository.getGreetings()).thenReturn(List.of("A", "B", "C"));

        String result = service.randomGreeting();

        assertThat(result).isIn("A", "B", "C");

        verify(repository).countGreetings();
        verify(repository).getGreetings();
    }
}
