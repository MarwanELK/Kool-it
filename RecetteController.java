package project.spring.backend_koolit.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Commentaire;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.service.RecetteService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recettes")
public class RecetteController {
    private final RecetteService recetteService;

    @Autowired
    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping
    public List<Recette> getAllRecettes() {
        return recetteService.getAllRecettes();
    }
@GetMapping("{id}")
public Recette findIngredientByRecetteId(@PathVariable Long id) {
    return recetteService.findRecetteByRecetteId(id);
}

    @PostMapping("/{recetteId}/commentaires")
    public void ajouterCommentaire(
            @PathVariable Long recetteId,
            @RequestBody Commentaire commentaire) {
        // Récupérez la recette depuis la base de données
        Recette recette = recetteService.getRecetteById(recetteId);

        // Ajoutez le commentaire à la recette
        recette.getCommentaires().add(commentaire);

        // Mettez à jour la recette dans la base de données
        recetteService.saveRecette(recette);
    }


    /*@GetMapping("/recette/{id}")
    public  String afficherRecetteParId(@PathVariable Long id, Model model) {
        Recette recette = RecetteRepository.findRecetteByRecetteId(id);
        List<Ingredient> ingredients = RecetteRepository.findIngredientByRecetteId(id);
        model.addAttribute("recette", recette);
        model.addAttribute("ingredients", ingredients);
        return "detailRecette";
    }*/
}
