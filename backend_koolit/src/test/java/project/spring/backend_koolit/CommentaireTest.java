package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import project.spring.backend_koolit.model.Commentaire;

import static org.junit.jupiter.api.Assertions.*;

public class CommentaireTest {

    @Test
    void testGetSetCommentaireId() {
        // Arrange
        Commentaire commentaire = new Commentaire();
        Long commentaireId = 1L;

        // Act
        commentaire.setCommentaireId(commentaireId);

        // Assert
        assertEquals(commentaireId, commentaire.getCommentaireId());
    }

    @Test
    void testGetSetUsername() {
        // Arrange
        Commentaire commentaire = new Commentaire();
        String username = "JohnDoe";

        // Act
        commentaire.setUsername(username);

        // Assert
        assertEquals(username, commentaire.getUsername());
    }

    @Test
    void testGetSetContenu() {
        // Arrange
        Commentaire commentaire = new Commentaire();
        String contenu = "Ceci est un commentaire.";

        // Act
        commentaire.setContenu(contenu);

        // Assert
        assertEquals(contenu, commentaire.getContenu());
    }

    @Test
    void testEquality() {
        // Arrange
        Commentaire commentaire1 = new Commentaire();
        commentaire1.setCommentaireId(1L);
        commentaire1.setUsername("JohnDoe");
        commentaire1.setContenu("Contenu1");

        Commentaire commentaire2 = new Commentaire();
        commentaire2.setCommentaireId(1L);
        commentaire2.setUsername("JohnDoe");
        commentaire2.setContenu("Contenu1");

        Commentaire commentaire3 = new Commentaire();
        commentaire3.setCommentaireId(2L);
        commentaire3.setUsername("JaneDoe");
        commentaire3.setContenu("Contenu2");

        // Act & Assert
        assertEquals(commentaire1, commentaire2);
        assertNotEquals(commentaire1, commentaire3);
    }

    @Test
    void testHashCode() {
        // Arrange
        Commentaire commentaire1 = new Commentaire();
        commentaire1.setCommentaireId(1L);
        commentaire1.setUsername("JohnDoe");
        commentaire1.setContenu("Contenu1");

        Commentaire commentaire2 = new Commentaire();
        commentaire2.setCommentaireId(1L);
        commentaire2.setUsername("JohnDoe");
        commentaire2.setContenu("Contenu1");

        // Act & Assert
        assertEquals(commentaire1.hashCode(), commentaire2.hashCode());
    }
}
