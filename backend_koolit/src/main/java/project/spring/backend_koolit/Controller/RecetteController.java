package project.spring.backend_koolit.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/{recetteId}/noter")
    public ResponseEntity<Recette> noterRecette(@PathVariable Long recetteId, @RequestParam Double note) {
        Recette recette = recetteService.noterRecette(recetteId, note);
        if (recette != null) {
            return new ResponseEntity<>(recette, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{recetteId}/augmenterPersonnes")
    public ResponseEntity<Recette> augmenterPart(@PathVariable Long recetteId, @RequestParam Integer nbPersonnes) {
        Recette recette = recetteService.augmenterPart(recetteId,nbPersonnes);
        if (recette != null) {
            return new ResponseEntity<>(recette, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
