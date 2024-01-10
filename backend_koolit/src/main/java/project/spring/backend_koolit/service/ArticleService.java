package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Article;
import project.spring.backend_koolit.repository.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticlesByBoutique(Long boutiqueId) {
        // Implémentez la logique pour récupérer les articles en fonction de la boutique
        // Utilisez le repository pour accéder à la base de données
        // Exemple : return articleRepository.findByBoutiqueId(boutiqueId);
        return null;
    }

    // Ajoutez d'autres méthodes nécessaires pour gérer les articles
}
