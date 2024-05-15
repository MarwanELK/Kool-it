package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.model.Wikingredients;

import java.util.List;
import java.util.Optional;

public interface WikingredientRepository extends JpaRepository<Wikingredients, Long> {

    @Query("SELECT DISTINCT w.composant FROM Wikingredients w WHERE w.nomAliment = :nomAliment")
    List<String> findComposantsByNomAliment(String nomAliment);

    List<Wikingredients> findByNomAliment(String nomAliment);

    @Query("SELECT w.nomAliment FROM Wikingredients w")
    List<String> findAllNomAliments();
}
