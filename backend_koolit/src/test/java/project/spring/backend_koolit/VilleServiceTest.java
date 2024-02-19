import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import project.spring.backend_koolit.model.Ville;
import project.spring.backend_koolit.repository.VilleRepository;
import project.spring.backend_koolit.service.VilleService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VilleServiceTest {

    @Mock
    private VilleRepository villeRepository;

    @InjectMocks
    private VilleService villeService;

    @Test
    void testGetVilleParNom() {
        // Arrange
        String nomVille = "Paris";
        Ville villeMock = new Ville(/* provide necessary constructor parameters */);
        when(villeRepository.findByNom(nomVille)).thenReturn(villeMock);

        // Act
        Ville result = villeService.getVilleParNom(nomVille);

        // Assert
        assertEquals(villeMock, result);

        // Verify that the repository method was called with the correct parameter
        verify(villeRepository).findByNom(nomVille);
    }

    @Test
    void testGetVilleParCoords() {
        // Arrange
        double lat = 48.8566;
        double lng = 2.3522;
        Ville villeMock = new Ville(/* provide necessary constructor parameters */);
        when(villeRepository.findByLatAndLng(lat, lng)).thenReturn(villeMock);

        // Act
        Ville result = villeService.getVilleParCoords(lat, lng);

        // Assert
        assertEquals(villeMock, result);

        // Verify that the repository method was called with the correct parameters
        verify(villeRepository).findByLatAndLng(lat, lng);
    }
}
