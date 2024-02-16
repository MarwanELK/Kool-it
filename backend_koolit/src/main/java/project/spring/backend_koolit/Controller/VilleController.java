package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.spring.backend_koolit.model.Ville;
import project.spring.backend_koolit.service.VilleService;

@RestController
@RequestMapping("/villes")
public class VilleController {
    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping("/rechercherNom")
    public ResponseEntity<Ville> rechercherVilleParNom(String nomVille){
        Ville ville = villeService.getVilleParNom(nomVille);
        return ResponseEntity.ok(ville);
    }

    @GetMapping("/rechercherCoords")
    public ResponseEntity<Ville> rechercherVilleParCoords(double lat, double lng){
        Ville ville = villeService.getVilleParCoords(lat,lng);
        return ResponseEntity.ok(ville);
    }
}