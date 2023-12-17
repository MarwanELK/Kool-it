package project.spring.backend_koolit.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.service.MagasinService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/magasins")
public class MagasinController {
    private static final Logger logger = LoggerFactory.getLogger(MagasinController.class);

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
    public ResponseEntity<List<Magasin>> rechercherMagasinParNom(@RequestParam String nom) {
        List<Magasin> magasins = magasinService.rechercherMagasinParNom(nom);
        return ResponseEntity.ok(magasins);
    }
    @GetMapping("/typesAliment/rechercher")
    public ResponseEntity<List<String>> rechercherTypeAlimentParNom(@RequestParam String nomType) {
        try {
            List<String> typesAliment = magasinService.rechercherTypeAlimentParNom(nomType);
            return ResponseEntity.ok(typesAliment);
        } catch (Exception e) {
            logger.error("Une erreur s'est produite lors de la recherche de types d'aliment.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/ajouterTypeAliment/{nom}")
    public ResponseEntity<List<String>> getTypeAliment(@PathVariable String nom) {
        try {
            Magasin magasin = magasinService.getMagasinByNom(nom);

            if (magasin != null) {
                String typeAlimentActuel = magasin.getTypeAliment();
                if (typeAlimentActuel == null) {
                    typeAlimentActuel = "[]"; // Initialisez avec une liste vide si elle est nulle
                }
                List<String> typesAliments = new ObjectMapper().readValue(typeAlimentActuel, List.class);

                return ResponseEntity.ok(typesAliments);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/ajouterTypeAliment/{nom}")
    public ResponseEntity<Void> ajouterTypeAliment(@PathVariable String nom, @RequestBody String typeAliment) {
        try {
            Magasin magasin = magasinService.getMagasinByNom(nom);

            if (magasin != null) {
                String typeAlimentActuel = magasin.getTypeAliment();
                if (typeAlimentActuel == null) {
                    typeAlimentActuel = "[]"; // Initialisez avec une liste vide si elle est nulle
                }

               Set<String> typesAlimentsSet = new ObjectMapper().readValue(typeAlimentActuel, Set.class);

                typesAlimentsSet.add(typeAliment.replace("\"", ""));

                List<String> typesAliments = new ArrayList<>(typesAlimentsSet);

                magasin.setTypeAliment(new ObjectMapper().writeValueAsString(typesAliments));
                magasinService.ajouterMagasin(magasin);

                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
