package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Magasin;

import java.util.List;
import java.util.Optional;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {
    List<Magasin> findByNomContainingIgnoreCase(String nomMagasin);
    Optional<Magasin> findByNom(String nom);
    List<Magasin> findMagasinsByVille(String ville);
}
