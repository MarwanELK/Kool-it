package project.spring.backend_koolit.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
}

