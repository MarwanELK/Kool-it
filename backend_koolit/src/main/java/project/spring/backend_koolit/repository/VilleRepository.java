package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.model.Ville;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long> {
    Ville findByNom(String nom);

    Ville findByLatAndLng(double lat, double lng);
}