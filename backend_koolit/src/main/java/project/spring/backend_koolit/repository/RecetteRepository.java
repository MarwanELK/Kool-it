package project.spring.backend_koolit.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.*;
import java.util.List;


public interface RecetteRepository extends JpaRepository<Recette, Long> {

    Recette findRecetteByRecetteId(Long id);
    List<Recette> findIngredientByRecetteId(Long id);
    public List<Recette> findAll();

    List<Commentaire> findCommentaireByRecetteId(Long id);

}