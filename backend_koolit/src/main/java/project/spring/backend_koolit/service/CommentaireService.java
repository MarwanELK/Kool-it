package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.repository.CommentaireRepository;



@Service
public class CommentaireService {
    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    public Commentaire ajouterCommentaire(Commentaire commentaire){
        commentaire.setCommentaireId(3L);
        return commentaireRepository.save(commentaire);
    }
}
