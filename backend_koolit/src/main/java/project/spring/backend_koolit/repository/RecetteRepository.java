package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.spring.backend_koolit.model.*;
import java.util.List;
import java.util.Optional;

public interface RecetteRepository extends JpaRepository<Recette, Long> {

    Recette findRecetteByRecetteId(Long id);

    List<Recette> findIngredientByRecetteId(Long id);
    public List<Recette> findAll();

    Optional<Recette> findById(Long id);


    List<Commentaire> findCommentaireByRecetteId(Long id);

}
