package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Article;
import project.spring.backend_koolit.model.Boutique;
import project.spring.backend_koolit.repository.BoutiqueRepository;

import java.util.List;

@Service
public class BoutiqueService {

    @Autowired
    private BoutiqueRepository boutiqueRepository;
    public List<Article> getArticlesByBoutique(Long boutiqueId) {
        Boutique boutique = boutiqueRepository.findById(boutiqueId).orElse(null);
        return (boutique != null) ? boutique.getArticles() : null;
    }

    public List<Boutique> getAllBoutiques() {
        return boutiqueRepository.findAll();
    }

    public Boutique getBoutiqueById(Long id) {
        return boutiqueRepository.findById(id).orElse(null);
    }

    public Boutique saveBoutique(Boutique boutique) {
        return boutiqueRepository.save(boutique);
    }

    public void deleteBoutique(Long id) {
        boutiqueRepository.deleteById(id);
    }
}
