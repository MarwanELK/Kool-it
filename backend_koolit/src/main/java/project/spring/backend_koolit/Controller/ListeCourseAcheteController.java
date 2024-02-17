package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.model.ListeCourseAchete;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.repository.ListeCourseRepository;
import project.spring.backend_koolit.service.ListeCourseAcheteService;
import project.spring.backend_koolit.service.ListeCourseService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/liste-courseAchete")
public class ListeCourseAcheteController {

    private final ListeCourseAcheteService listeCourseAcheteService;

    @Autowired
    public ListeCourseAcheteController(ListeCourseAcheteService listeCourseAcheteService) {
        this.listeCourseAcheteService = listeCourseAcheteService;
    }

    @GetMapping
    public List<ListeCourseAchete> getAllListesCourses() {
        return listeCourseAcheteService.getAllListesCourse();
    }

    @GetMapping("/{idUtilisateur}")
    public List<ListeCourseAchete> getListesCourseByUtilisateur(@PathVariable Long idUtilisateur) {
        return listeCourseAcheteService.getListesCourseByUtilisateur(idUtilisateur);
    }

    @PostMapping("/{idUtilisateur}")
    public ResponseEntity<ListeCourseAchete> ajouterListeCourse(@RequestBody ListeCourseAchete nouvelleListeCourse) {
        try {
            ListeCourseAchete listeCourseAchete = listeCourseAcheteService.ajouterListeCourse(nouvelleListeCourse);
            return ResponseEntity.ok(listeCourseAchete);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerIngredient(@PathVariable Long id) {
        try {
            // Logique pour supprimer l'ingrédient avec l'ID spécifié
            listeCourseAcheteService.supprimerIngredient(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/acheter/{id}")
    public ResponseEntity<Optional<ListeCourseAchete>> acheterIngredient(@PathVariable Long id) {
        Optional<ListeCourseAchete> listeCourse = listeCourseAcheteService.acheterIngredient(id);
        return ResponseEntity.ok(listeCourse);
    }

    // Ajoutez cette méthode pour gérer les requêtes OPTIONS
    @RequestMapping(value = "/{idUtilisateur}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptionsRequest() {
        return ResponseEntity.ok().build();
    }
}