package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Magasin;

import java.util.List;
import java.util.Optional;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {
    Optional<Magasin> findByNom(String nom);
    List<Magasin> findMagasinsByVille(String ville);

    List<Magasin> findMagasinByNom(String nom);

    List<Magasin> findMagasinsByNomAndVille(String nom, String ville);


}
