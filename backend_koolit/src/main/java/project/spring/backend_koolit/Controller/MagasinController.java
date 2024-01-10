package project.spring.backend_koolit.Controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.service.MagasinService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    // Nouvelle méthode pour récupérer les magasins à proximité en utilisant Overpass
    @GetMapping("/magasins-proximite")
    public ResponseEntity<List<Magasin>> getMagasinsProximite(@RequestParam double latitude, @RequestParam double longitude) {
        // Construisez l'URL de l'API Overpass en utilisant les paramètres latitude et longitude
        String overpassApiUrl = "https://overpass-api.de/api/interpreter?data=[out:json];(node[\"shop\"](around:3000," + latitude + "," + longitude + "););out;";

        // Utilisez RestTemplate pour faire la requête vers l'API Overpass
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(overpassApiUrl, String.class);

        // Parsez la chaîne de résultat en une liste d'objets Magasin
        List<Magasin> magasins = parseMagasinsFromJson(result);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(magasins, headers, HttpStatus.OK);
    }

    // Méthode auxiliaire pour parser la chaîne JSON en une liste d'objets Magasin
    private List<Magasin> parseMagasinsFromJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, new TypeReference<List<Magasin>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
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
    public ResponseEntity<List<Magasin>> rechercherMagasinParNom(String nomMagasin) {
        System.out.println("Le param transmis est "+nomMagasin);
        List<Magasin> magasins = magasinService.rechercherMagasinParNom(nomMagasin);
        return ResponseEntity.ok(magasins);
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

    @GetMapping("/coccinelle")
    public ResponseEntity<Magasin> getCoccinelle() {
        Magasin magasin = magasinService.getMagasinByNom("Coccinelle Supermarché");
        return ResponseEntity.ok(magasin);
    }

    @GetMapping("/ville")
    public ResponseEntity<List<Magasin>> getMagasinsParVille(String ville) {
        List<Magasin> magasins = magasinService.rechercherMagasinsParVille(ville);
        return ResponseEntity.ok(magasins);
    }

}
