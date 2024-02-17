package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.service.CommentaireService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {
    private final CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @PostMapping
    public ResponseEntity<Commentaire> ajouterCommentaire(@RequestBody Commentaire nouveauCommentaire) {
        Commentaire commentaireAjoute = commentaireService.ajouterCommentaire(nouveauCommentaire);
        return new ResponseEntity<>(commentaireAjoute, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentaireId}")
    public ResponseEntity<?> supprimerCommentaire(@PathVariable Long commentaireId) {
        try {
            commentaireService.supprimerCommentaire(commentaireId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}