package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.repository.CommentaireRepository;
import project.spring.backend_koolit.service.CommentaireService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommentaireServiceTest {

    @Mock
    private CommentaireRepository commentaireRepository;

    @InjectMocks
    private CommentaireService commentaireService;

    @Test
    void testAjouterCommentaire() {
        // Arrange
        Commentaire commentaireToAdd = new Commentaire(/* provide necessary constructor parameters */);

        // Mocking the repository behavior
        when(commentaireRepository.save(Mockito.any(Commentaire.class))).thenReturn(commentaireToAdd);

        // Act
        Commentaire result = commentaireService.ajouterCommentaire(commentaireToAdd);

        // Assert
        assertEquals(commentaireToAdd, result);

        // Verify that the repository method was called with the correct parameter
        verify(commentaireRepository).save(commentaireToAdd);
    }
}
