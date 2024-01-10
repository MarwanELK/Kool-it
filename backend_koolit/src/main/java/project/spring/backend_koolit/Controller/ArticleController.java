package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Article;
import project.spring.backend_koolit.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/boutique/{boutiqueId}")
    public ResponseEntity<List<Article>> getArticlesByBoutique(@PathVariable Long boutiqueId) {
        try {
            List<Article> articles = articleService.getArticlesByBoutique(boutiqueId);
            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e) {
            // Gérer l'erreur, loguer, etc.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Ajoutez d'autres méthodes nécessaires pour gérer les articles
}
