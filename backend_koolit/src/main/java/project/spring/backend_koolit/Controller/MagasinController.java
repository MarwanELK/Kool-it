package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.service.MagasinService;

import java.util.List;

@RestController
@RequestMapping("/magasins")
public class MagasinController {

    private final MagasinService magasinService;

    @Autowired
    public MagasinController(MagasinService magasinService) {
        this.magasinService = magasinService;
    }

    @GetMapping
    public ResponseEntity<List<Magasin>> getAllMagasins() {
        List<Magasin> magasins = magasinService.getAllMagasins();
        return ResponseEntity.ok(magasins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Magasin> getMagasinById(@PathVariable Long id) {
        Magasin magasin = magasinService.getMagasinById(id);
        return ResponseEntity.ok(magasin);
    }

    @PostMapping
    public ResponseEntity<Magasin> ajouterMagasin(@RequestBody Magasin magasin) {
        Magasin nouveauMagasin = magasinService.ajouterMagasin(magasin);
        return ResponseEntity.ok(nouveauMagasin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Magasin> modifierMagasin(@PathVariable Long id, @RequestBody Magasin magasin) {
        Magasin magasinModifie = magasinService.modifierMagasin(id, magasin);
        return ResponseEntity.ok(magasinModifie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMagasin(@PathVariable Long id) {
        magasinService.supprimerMagasin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rechercher")
    public ResponseEntity<List<Magasin>> rechercherMagasinParNom(@RequestParam String nomMagasin) {
        List<Magasin> magasins = magasinService.rechercherMagasinParNom(nomMagasin);
        return ResponseEntity.ok(magasins);
    }
    @PostMapping("/ajouterTypeAliment/{nomMagasin}")
    public ResponseEntity<Void> ajouterTypeAliment(@PathVariable String nomMagasin, @RequestBody String typeAliment) {
        // Implémentez la logique pour ajouter le type d'aliment au magasin spécifié
        // Assurez-vous de mettre à jour la base de données en conséquence
        return ResponseEntity.ok().build();
    }
}
