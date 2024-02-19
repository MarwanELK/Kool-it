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

    @Test
    public void testGetAllMagasins() {
        // Mocking data
        Magasin magasin1 = new Magasin( "Supermarket ABC", "Grocery", "http://example.com", "Food");
        Magasin magasin2 = new Magasin("Corner Store XYZ", "Convenience Store", "http://example.com", "Snacks");
        List<Magasin> mockedMagasins = Arrays.asList(magasin1, magasin2);


        when(magasinRepository.findAll()).thenReturn(mockedMagasins);

        List<Magasin> result = magasinService.getAllMagasins();


        verify(magasinRepository, times(1)).findAll();


        assertEquals(2, result.size());
        assertEquals("Supermarket ABC", result.get(0).getNom());
        assertEquals("Corner Store XYZ", result.get(1).getNom());
    }

    @Test
    public void testGetMagasinById() {

        Long magasinId = 1L;
        Magasin magasin = new Magasin( "Supermarket ABC", "Grocery", "http://example.com", "Food");


        when(magasinRepository.findById(magasinId)).thenReturn(Optional.of(magasin));


        Magasin result = magasinService.getMagasinById(magasinId);

        verify(magasinRepository, times(1)).findById(magasinId);


        assertEquals(magasinId, result.getId());
        assertEquals("Supermarket ABC", result.getNom());
    }

    // Add more tests for other methods as needed
}
