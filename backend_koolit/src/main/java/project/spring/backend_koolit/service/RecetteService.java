package project.spring.backend_koolit.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.repository.CommentaireRepository;
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

    public Recette augmenterPart(Long recetteId, Integer nbPersonnes){
        Recette recette = repository.findRecetteByRecetteId(recetteId);
        if (recette != null) {
            if (recette.getNbPersonnes()== null) {
                recette.setNotes(new ArrayList<>());
            }
            recette.setNbPersonnes(nbPersonnes);
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
    }

    public List<Commentaire> getCommentaireByRecetteId(Long recetteId) {
        return repository.findCommentaireByRecetteId(recetteId);
    }

    public Recette envoyerCommentaire(Long recetteId, Commentaire commentaire) {
        // Vérifiez si la recette existe
        Recette recette = repository.findById(recetteId).orElseThrow(() -> new EntityNotFoundException("Recette non trouvée avec l'ID: " + recetteId));

        // Ajoutez le commentaire à la liste de commentaires de la recette
        if(recette.getCommentaires().isEmpty()){
            List<Commentaire> lc = new ArrayList<>();
            recette.setCommentaires(lc);
        }
        recette.getCommentaires().add(commentaire);
        // Enregistrez la recette mise à jour
        return repository.save(recette);
    }

    public void supprimerCommentaire(Long commentaireId){
        repository.deleteById(commentaireId);
    }

}
