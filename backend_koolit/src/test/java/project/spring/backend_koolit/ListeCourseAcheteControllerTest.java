package project.spring.backend_koolit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.spring.backend_koolit.Controller.ListeCourseAcheteController;
import project.spring.backend_koolit.model.ListeCourseAchete;
import project.spring.backend_koolit.service.ListeCourseAcheteService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListeCourseAcheteControllerTest {

    @Mock
    private ListeCourseAcheteService listeCourseAcheteService;

    @InjectMocks
    private ListeCourseAcheteController listeCourseAcheteController;

    @Test
    public void testGetAllListesCourses() {
        // Arrange
        List<ListeCourseAchete> expectedListesCourses = Collections.emptyList();
        when(listeCourseAcheteService.getAllListesCourse()).thenReturn(expectedListesCourses);

        // Act
        List<ListeCourseAchete> actualListesCourses = listeCourseAcheteController.getAllListesCourses();

        // Assert
        assertEquals(expectedListesCourses, actualListesCourses);
    }

    @Test
    public void testGetListesCourseByUtilisateur() {
        // Arrange
        Long idUtilisateur = 1L;
        List<ListeCourseAchete> expectedListesCourses = Collections.emptyList();
        when(listeCourseAcheteService.getListesCourseByUtilisateur(idUtilisateur)).thenReturn(expectedListesCourses);

        // Act
        List<ListeCourseAchete> actualListesCourses = listeCourseAcheteController.getListesCourseByUtilisateur(idUtilisateur);

        // Assert
        assertEquals(expectedListesCourses, actualListesCourses);
    }

    @Test
    public void testAjouterListeCourse() {
        // Arrange
        ListeCourseAchete nouvelleListeCourse = new ListeCourseAchete();
        when(listeCourseAcheteService.ajouterListeCourse(nouvelleListeCourse)).thenReturn(nouvelleListeCourse);

        // Act
        ResponseEntity<ListeCourseAchete> response = listeCourseAcheteController.ajouterListeCourse(nouvelleListeCourse);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(nouvelleListeCourse, response.getBody());
    }

    @Test
    public void testSupprimerIngredient() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<?> response = listeCourseAcheteController.supprimerIngredient(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(listeCourseAcheteService, times(1)).supprimerIngredient(id);
    }

    @Test
    public void testAcheterIngredient() {
        // Arrange
        Long id = 1L;
        Optional<ListeCourseAchete> listeCourse = Optional.of(new ListeCourseAchete());
        when(listeCourseAcheteService.acheterIngredient(id)).thenReturn(listeCourse);

        // Act
        ResponseEntity<Optional<ListeCourseAchete>> response = listeCourseAcheteController.acheterIngredient(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listeCourse, response.getBody());
    }

    @Test
    public void testHandleOptionsRequest() {
        // Act
        ResponseEntity<?> response = listeCourseAcheteController.handleOptionsRequest();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
