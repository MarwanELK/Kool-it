package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{
    Commentaire findByCommentaireId(Long commentaireId);

}