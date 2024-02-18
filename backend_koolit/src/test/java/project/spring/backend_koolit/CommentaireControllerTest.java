package project.spring.backend_koolit.Controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.service.CommentaireService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CommentaireControllerTest {

    @Mock
    private CommentaireService commentaireService;

    @InjectMocks
    private CommentaireController commentaireController;

    public CommentaireControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAjouterCommentaire() {
        // Création d'un commentaire fictif
        Commentaire nouveauCommentaire = new Commentaire();
        nouveauCommentaire.setId(1L);
        nouveauCommentaire.setContenu("Contenu du commentaire");

        // Configuration du comportement du service mocké
        when(commentaireService.ajouterCommentaire(nouveauCommentaire)).thenReturn(nouveauCommentaire);

        // Appel de la méthode à tester
        ResponseEntity<Commentaire> responseEntity = commentaireController.ajouterCommentaire(nouveauCommentaire);

        // Vérification du code de statut de la réponse
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        // Vérification de la réponse
        assertEquals(nouveauCommentaire, responseEntity.getBody());
    }

    @Test
    public void testSupprimerCommentaire() {
        // ID du commentaire fictif à supprimer
        Long commentaireId = 1L;

        // Appel de la méthode à tester
        ResponseEntity<?> responseEntity = commentaireController.supprimerCommentaire(commentaireId);

        // Vérification du code de statut de la réponse
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Vérification de l'appel à la méthode de service correspondante
        verify(commentaireService, times(1)).supprimerCommentaire(commentaireId);
    }

    // Ajoutez d'autres tests pour les autres méthodes de CommentaireController en fonction de vos besoins
}
