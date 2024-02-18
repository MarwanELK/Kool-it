package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.spring.backend_koolit.model.Ville;
import project.spring.backend_koolit.repository.VilleRepository;
import project.spring.backend_koolit.service.VilleService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
public class VilleRepositoryTest {

    @Mock
    private VilleRepository villeRepository;

    @InjectMocks
    private VilleService villeService;

    @Test
    void testFindByNom() {
        // Arrange
        String nomVille = "Paris";
        Ville villeMock = new Ville(/* provide necessary constructor parameters */);
        when(villeRepository.findByNom(nomVille)).thenReturn(villeMock);

        // Act
        Ville result = villeRepository.findByNom(nomVille);

        // Assert
        assertEquals(villeMock, result);

        // Verify that the repository method was called with the correct parameter
        verify(villeRepository).findByNom(nomVille);
    }

    @Test
    void testFindByLatAndLng() {
        // Arrange
        double lat = 48.8566;
        double lng = 2.3522;
        Ville villeMock = new Ville(/* provide necessary constructor parameters */);
        when(villeRepository.findByLatAndLng(lat, lng)).thenReturn(villeMock);

        // Act
        Ville result = villeRepository.findByLatAndLng(lat, lng);

        // Assert
        assertEquals(villeMock, result);

        // Verify that the repository method was called with the correct parameters
        verify(villeRepository).findByLatAndLng(lat, lng);
    }

    @Test
    void testSave() {
        // Arrange
        Ville villeToSave = new Ville(/* provide necessary constructor parameters */);
        when(villeRepository.save(villeToSave)).thenReturn(villeToSave);

        // Act
        Ville result = villeRepository.save(villeToSave);

        // Assert
        assertEquals(villeToSave, result);

        // Verify that the repository method was called with the correct parameter
        verify(villeRepository).save(villeToSave);
    }

    @Test
    void testDeleteById() {
        // Arrange
        Long villeId = 1L;

        // Act
        villeRepository.deleteById(villeId);

        // Verify that the repository method was called with the correct parameter
        verify(villeRepository).deleteById(villeId);
    }
}
