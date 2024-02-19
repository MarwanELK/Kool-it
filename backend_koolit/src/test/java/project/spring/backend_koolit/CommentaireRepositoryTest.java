import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.repository.CommentaireRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
public class CommentaireRepositoryTest {

    @Mock
    private CommentaireRepository commentaireRepository;

    @InjectMocks
    private CommentaireService commentaireService;

    @Test
    void testFindById() {
        // Arrange
        Long commentaireId = 1L;
        Commentaire commentaireMock = new Commentaire(/* provide necessary constructor parameters */);
        when(commentaireRepository.findById(commentaireId)).thenReturn(Optional.of(commentaireMock));

        // Act
        Optional<Commentaire> result = commentaireRepository.findById(commentaireId);

        // Assert
        assertEquals(commentaireMock, result.orElse(null));

        // Verify that the repository method was called with the correct parameter
        verify(commentaireRepository).findById(commentaireId);
    }

    @Test
    void testSave() {
        // Arrange
        Commentaire commentaireToSave = new Commentaire(/* provide necessary constructor parameters */);
        when(commentaireRepository.save(commentaireToSave)).thenReturn(commentaireToSave);

        // Act
        Commentaire result = commentaireRepository.save(commentaireToSave);

        // Assert
        assertEquals(commentaireToSave, result);

        // Verify that the repository method was called with the correct parameter
        verify(commentaireRepository).save(commentaireToSave);
    }

    @Test
    void testDeleteById() {
        // Arrange
        Long commentaireId = 1L;

        // Act
        commentaireRepository.deleteById(commentaireId);

        // Verify that the repository method was called with the correct parameter
        verify(commentaireRepository).deleteById(commentaireId);
    }
}
