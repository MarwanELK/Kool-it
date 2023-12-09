package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Magasin;

import java.util.List;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {
    List<Magasin> findByNomContainingIgnoreCase(String nomMagasin);
    Magasin findByNom(String nom);}
