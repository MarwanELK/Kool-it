package project.spring.backend_koolit.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.service.RecetteService;

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


    /*@GetMapping("/recette/{id}")
    public  String afficherRecetteParId(@PathVariable Long id, Model model) {
        Recette recette = RecetteRepository.findRecetteByRecetteId(id);
        List<Ingredient> ingredients = RecetteRepository.findIngredientByRecetteId(id);
        model.addAttribute("recette", recette);
        model.addAttribute("ingredients", ingredients);
        return "detailRecette";
    }*/
}
