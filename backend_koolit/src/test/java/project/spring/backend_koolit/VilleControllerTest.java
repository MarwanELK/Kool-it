package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.spring.backend_koolit.Controller.VilleController;
import project.spring.backend_koolit.model.Ville;
import project.spring.backend_koolit.service.VilleService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VilleControllerTest {

    @Mock
    private VilleService villeService;

    @InjectMocks
    private VilleController villeController;

    @Test
    void testRechercherVilleParNom() {
        // Arrange
        String nomVille = "Paris";
        Ville villeMock = new Ville(/* provide necessary constructor parameters */);
        when(villeService.getVilleParNom(nomVille)).thenReturn(villeMock);

        // Act
        ResponseEntity<Ville> responseEntity = villeController.rechercherVilleParNom(nomVille);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(villeMock, responseEntity.getBody());
        // Add more assertions as needed for the response headers or other properties

        // Verify that the service method was called with the correct parameter
        verify(villeService).getVilleParNom(nomVille);
    }

    @Test
    void testRechercherVilleParCoords() {
        // Arrange
        double lat = 48.8566;
        double lng = 2.3522;
        Ville villeMock = new Ville(/* provide necessary constructor parameters */);
        when(villeService.getVilleParCoords(lat, lng)).thenReturn(villeMock);

        // Act
        ResponseEntity<Ville> responseEntity = villeController.rechercherVilleParCoords(lat, lng);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(villeMock, responseEntity.getBody());
        // Add more assertions as needed for the response headers or other properties

        // Verify that the service method was called with the correct parameters
        verify(villeService).getVilleParCoords(lat, lng);
    }

    @Test
    void testRechercherVilleParNomNotFound() {
        // Arrange
        String nomVille = "VilleInexistante";
        when(villeService.getVilleParNom(nomVille)).thenReturn(null);

        // Act
        ResponseEntity<Ville> responseEntity = villeController.rechercherVilleParNom(nomVille);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        // Add more assertions as needed for the response headers or other properties

        // Verify that the service method was called with the correct parameter
        verify(villeService).getVilleParNom(nomVille);
    }

    @Test
    void testRechercherVilleParCoordsNotFound() {
        // Arrange
        double lat = 48.8566;
        double lng = 2.3522;
        when(villeService.getVilleParCoords(lat, lng)).thenReturn(null);

        // Act
        ResponseEntity<Ville> responseEntity = villeController.rechercherVilleParCoords(lat, lng);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        // Add more assertions as needed for the response headers or other properties

        // Verify that the service method was called with the correct parameters
        verify(villeService).getVilleParCoords(lat, lng);
    }

    @Test
    void testRechercherVilleParNomException() {
        // Arrange
        String nomVille = "Paris";
        when(villeService.getVilleParNom(nomVille)).thenThrow(new RuntimeException("Erreur lors de la recherche de la ville"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> villeController.rechercherVilleParNom(nomVille));

        // Verify that the service method was called with the correct parameter
        verify(villeService).getVilleParNom(nomVille);
    }

    @Test
    void testRechercherVilleParCoordsException() {
        // Arrange
        double lat = 48.8566;
        double lng = 2.3522;
        when(villeService.getVilleParCoords(lat, lng)).thenThrow(new RuntimeException("Erreur lors de la recherche de la ville"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> villeController.rechercherVilleParCoords(lat, lng));

        // Verify that the service method was called with the correct parameters
        verify(villeService).getVilleParCoords(lat, lng);
    }
}
