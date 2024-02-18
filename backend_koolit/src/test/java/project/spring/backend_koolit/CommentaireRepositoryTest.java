package project.spring.backend_koolit.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.spring.backend_koolit.model.Commentaire;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CommentaireRepositoryTest {

    @MockBean
    private CommentaireRepository commentaireRepository;

    @Test
    public void testFindByCommentaireId() {
        // ID du commentaire fictif à rechercher
        Long commentaireId = 1L;

        // Création d'un commentaire fictif
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaireId(commentaireId);
        commentaire.setContenu("Contenu du commentaire");

        // Configuration du comportement du repository mocké
        when(commentaireRepository.findByCommentaireId(commentaireId)).thenReturn(commentaire);

        // Appel de la méthode à tester
        Optional<Commentaire> result = commentaireRepository.findById(commentaireId);

        // Vérification du résultat
        assertEquals(commentaire, result.orElse(null));
    }

    // Ajoutez d'autres tests pour les autres méthodes de CommentaireRepository en fonction de vos besoins
}
