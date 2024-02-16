package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Boutique;

public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {
}