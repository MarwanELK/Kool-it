package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Discussion;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    // Add custom queries if needed

}
