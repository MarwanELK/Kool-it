import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.spring.backend_koolit.controller.CommentaireController;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.service.CommentaireService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommentaireControllerTest {

    @Mock
    private CommentaireService commentaireService;

    @InjectMocks
    private CommentaireController commentaireController;

    @Test
    void testAjouterCommentaire() {
        // Arrange
        Commentaire nouveauCommentaire = new Commentaire();
        when(commentaireService.ajouterCommentaire(Mockito.any(Commentaire.class)))
                .thenReturn(new Commentaire(/* provide necessary constructor parameters */));

        // Act
        ResponseEntity<Commentaire> responseEntity = commentaireController.ajouterCommentaire(nouveauCommentaire);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        // Add more assertions as needed for the response body or headers

        // Verify that the service method was called with the correct parameter
        verify(commentaireService).ajouterCommentaire(nouveauCommentaire);
    }

    @Test
    void testSupprimerCommentaire() {
        // Arrange
        Long commentaireId = 1L;
        when(commentaireService.supprimerCommentaire(commentaireId)).thenReturn(true);

        // Act
        ResponseEntity<?> responseEntity = commentaireController.supprimerCommentaire(commentaireId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions as needed for the response body or headers

        // Verify that the service method was called with the correct parameter
        verify(commentaireService).supprimerCommentaire(commentaireId);
    }

    @Test
    void testSupprimerCommentaireException() {
        // Arrange
        Long commentaireId = 1L;
        when(commentaireService.supprimerCommentaire(commentaireId)).thenThrow(new RuntimeException("Erreur lors de la suppression"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> commentaireController.supprimerCommentaire(commentaireId));

        // Verify that the service method was called with the correct parameter
        verify(commentaireService).supprimerCommentaire(commentaireId);
    }
}
