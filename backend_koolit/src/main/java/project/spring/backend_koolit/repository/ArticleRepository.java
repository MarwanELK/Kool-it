package project.spring.backend_koolit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Ajoutez des méthodes de requête personnalisées ici
    // Exemple : List<Article> findByBoutiqueId(Long boutiqueId);
}

