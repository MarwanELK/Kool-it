package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.model.ListeCourseAchete;

import java.util.List;
import java.util.Optional;

public interface ListeCourseAcheteRepository extends JpaRepository<ListeCourseAchete, Long> {
    List<ListeCourseAchete> findByUtilisateurId(Long idUtilisateur);
    Optional<ListeCourseAchete> findById(Long id);
}