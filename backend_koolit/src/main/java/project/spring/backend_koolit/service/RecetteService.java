package project.spring.backend_koolit.service;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.repository.RecetteRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class RecetteService {
    private final RecetteRepository repository;

    @Autowired
    public RecetteService(RecetteRepository repository) {
        this.repository = repository;
    }

    public Recette findRecetteByRecetteId(Long id) {
        return repository.findRecetteByRecetteId(id);
    }
    public List<Recette> findAllRecettes() {
        return repository.findAll();
    }
    public List<Ingredient> findIngredientByRecetteId(Long id) {
        Recette recette = findRecetteByRecetteId(id);
        if (recette == null){

            return null;
        }
        List<Ingredient> retour = new ArrayList<>();
        for (Ingredient i : recette.getIngredients()) {
            retour.add(i);
        }
        return retour;
    }
}
