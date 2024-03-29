package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.ListeCourse;

import java.util.List;
import java.util.Optional;

public interface ListeCourseRepository extends JpaRepository<ListeCourse, Long> {
    List<ListeCourse> findByUtilisateurId(Long idUtilisateur);
    Optional<ListeCourse> findById(Long id);
}