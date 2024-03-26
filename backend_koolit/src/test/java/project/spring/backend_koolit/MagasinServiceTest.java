package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.repository.MagasinRepository;
import project.spring.backend_koolit.service.MagasinService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MagasinServiceTest {

    @Mock
    private MagasinRepository magasinRepository;

    @InjectMocks
    private MagasinService magasinService;


    // Add more tests for other methods as needed
}
