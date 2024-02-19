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
        Magasin magasin1 = new Magasin("Supermarket ABC", "Grocery", "http://example.com", "Food");
        Magasin magasin2 = new Magasin("Corner Store XYZ", "Convenience Store", "http://example.com", "Snacks");
        List<Magasin> mockedMagasins = Arrays.asList(magasin1, magasin2);

        when(magasinRepository.findByNomContainingIgnoreCase(searchKeyword)).thenReturn(mockedMagasins);


        List<Magasin> result = magasinRepository.findByNomContainingIgnoreCase(searchKeyword);


        verify(magasinRepository, times(1)).findByNomContainingIgnoreCase(searchKeyword);


        assertEquals(2, result.size());
        assertEquals("Supermarket ABC", result.get(0).getNom());
        assertEquals("Corner Store XYZ", result.get(1).getNom());
    }

    @Test
    public void testFindByNom() {
        // Mocking data
        String magasinNom = "Supermarket ABC";
        Magasin magasin = new Magasin( magasinNom, "Grocery", "http://example.com", "Food");

        when(magasinRepository.findByNom(magasinNom)).thenReturn(Optional.of(magasin));

        Optional<Magasin> result = magasinRepository.findByNom(magasinNom);

        verify(magasinRepository, times(1)).findByNom(magasinNom);

        assertEquals(magasinNom, result.get().getNom());
    }

}
