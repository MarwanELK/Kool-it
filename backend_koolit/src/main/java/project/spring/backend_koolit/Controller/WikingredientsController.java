package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Wikingredients;
import project.spring.backend_koolit.service.WikingredientsService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/wikingredients")
public class WikingredientsController {

    private final WikingredientsService wikingredientsService;

    @Autowired
    public WikingredientsController(WikingredientsService wikingredientsService) {
        this.wikingredientsService = wikingredientsService;
    }

    @GetMapping
    public ResponseEntity<List<Wikingredients>> getAllWikingredients() {
        try {
            List<Wikingredients> wikingredients = wikingredientsService.getAllWikingredients();
            return ResponseEntity.ok(wikingredients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/nom")
    public ResponseEntity<List<String>> getAllNomAliments() {
        try {
            List<String> nomsAliments = wikingredientsService.getAllNomAliments();
            return ResponseEntity.ok(nomsAliments);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/composants/{nomAliment}")
    public ResponseEntity<List<String>> rechercherComposants(@PathVariable String nomAliment) {
        List<String> composants = wikingredientsService.findComposantsByNomAliment(nomAliment);
        return ResponseEntity.ok(composants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wikingredients> getWikingredientById(@PathVariable Long id) {
        try {
            Optional<Wikingredients> wikingredient = wikingredientsService.getWikingredientById(id);
            return wikingredient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/nom/{nomAliment}")
    public ResponseEntity<List<Wikingredients>> getWikingredientsByNomAliment(@PathVariable String nomAliment) {
        try {
            List<Wikingredients> wikingredients = wikingredientsService.getWikingredientsByNomAliment(nomAliment);
            return ResponseEntity.ok(wikingredients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PostMapping
    public ResponseEntity<Wikingredients> ajouterWikingredient(@RequestBody Wikingredients wikingredient) {
        try {
            Wikingredients createdWikingredient = wikingredientsService.ajouterComposant(wikingredient);
            return ResponseEntity.ok(createdWikingredient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerWikingredient(@PathVariable Long id) {
        try {
            wikingredientsService.supprimerWikingredient(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptionsRequest() {
        return ResponseEntity.ok().build();
    }
}
