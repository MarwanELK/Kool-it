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
public class MagasinRepositoryTest {

    @Mock
    private MagasinRepository magasinRepository;

    @InjectMocks
    private MagasinService magasinService;

    @Test
    public void testFindByNomContainingIgnoreCase() {

        String searchKeyword = "supermarket";

    }



}
