package project.spring.backend_koolit.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.ListeDeCourses;

public interface ListeDeCoursesRepository extends JpaRepository<ListeDeCourses, Long> {
}
