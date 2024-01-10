package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Article;
import project.spring.backend_koolit.model.Boutique;
import project.spring.backend_koolit.service.BoutiqueService;

import java.util.List;

@RestController
@RequestMapping("/boutiques")
public class BoutiqueController {

    @Autowired
    private BoutiqueService boutiqueService;

    @GetMapping("/{id}/articles")
    public ResponseEntity<List<Article>> getArticlesByBoutique(@PathVariable Long id) {
        try {
            Boutique boutique = boutiqueService.getBoutiqueById(id);
            if (boutique != null) {
                List<Article> articles = boutique.getArticles();
                return new ResponseEntity<>(articles, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Boutique getBoutiqueById(@PathVariable Long id) {
        return boutiqueService.getBoutiqueById(id);
    }

    @PostMapping
    public Boutique saveBoutique(@RequestBody Boutique boutique) {
        return boutiqueService.saveBoutique(boutique);
    }

    @DeleteMapping("/{id}")
    public void deleteBoutique(@PathVariable Long id) {
        boutiqueService.deleteBoutique(id);
    }
}
