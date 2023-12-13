package project.spring.backend_koolit.service;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.repository.RecetteRepository;

import java.util.ArrayList;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service

public class RecetteService {
    private final RecetteRepository repository;

    @Autowired
    public RecetteService(RecetteRepository repository) {
        this.repository = repository;
    }

    public Recette findRecetteByRecetteId(Long id) {
        Recette recette = repository.findRecetteByRecetteId(id);
        if (recette != null) {
            // Vérifiez les ingrédients dans les logs
            System.out.println("Ingrédients associés à la recette : " + recette.getIngredients());
        }
        return recette;
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

    public List<Recette> getAllRecettes() {
        List<Recette> recettes = repository.findAll();

        for (Recette recette : recettes) {
            double note = recette.getNote();
            recette.setNote(note);
        }

        return recettes;
    }
    public Recette noterRecette(Long recetteId, Double note) {
        Recette recette = repository.findRecetteByRecetteId(recetteId);
        if (recette != null) {
            if (recette.getNotes() == null) {
                recette.setNotes(new ArrayList<>());
            }
            recette.getNotes().add(note);
            recette.setNote(calculerMoyenneNotes(recette.getNotes()));
            repository.save(recette);
        }
        return recette;
    }

    private Double calculerMoyenneNotes(List<Double> notes) {
        if (notes != null && !notes.isEmpty()) {
            double somme = 0;
            for (Double note : notes) {
                somme += note;
            }
            return somme / notes.size();
        }
        return 0.0;
    }}
