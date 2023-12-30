package project.spring.backend_koolit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Wikingredients;
import project.spring.backend_koolit.repository.WikingredientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WikingredientsService {

    private final WikingredientRepository wikingredientRepository;

    @Autowired
    public WikingredientsService(WikingredientRepository wikingredientRepository) {
        this.wikingredientRepository = wikingredientRepository;
    }

    public List<Wikingredients> getAllWikingredients() {
        return wikingredientRepository.findAll();
    }

    public Optional<Wikingredients> getWikingredientById(Long id) {
        return wikingredientRepository.findById(id);
    }

    public List<Wikingredients> getWikingredientsByNomAliment(String nomAliment) {
        return wikingredientRepository.findByNomAliment(nomAliment);
    }

    public Wikingredients ajouterComposant(Wikingredients wikingredient) {
        return wikingredientRepository.save(wikingredient);
    }

    public void supprimerWikingredient(Long id) {
        wikingredientRepository.deleteById(id);
    }


    public List<String> findComposantsByNomAliment(String nomAliment) {
        return wikingredientRepository.findComposantsByNomAliment(nomAliment);
    }

    public List<String> getAllNomAliments() {
        return wikingredientRepository.findAllNomAliments();
    }
}

