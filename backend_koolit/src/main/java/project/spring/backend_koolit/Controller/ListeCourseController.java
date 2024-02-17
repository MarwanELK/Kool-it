package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.repository.ListeCourseRepository;
import project.spring.backend_koolit.service.ListeCourseService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/liste-course")
public class ListeCourseController {

    private final ListeCourseService listeCourseService;

    @Autowired
    public ListeCourseController(ListeCourseService listeCourseService) {
        this.listeCourseService = listeCourseService;
    }

    @GetMapping
    public List<ListeCourse> getAllListesCourses() {
        return listeCourseService.getAllListesCourse();
    }

    @GetMapping("/{idUtilisateur}")
    public List<ListeCourse> getListesCourseByUtilisateur(@PathVariable Long idUtilisateur) {
        return listeCourseService.getListesCourseByUtilisateur(idUtilisateur);
    }

    @PostMapping("/{idUtilisateur}")
    public ResponseEntity<ListeCourse> ajouterListeCourse(@RequestBody ListeCourse nouvelleListeCourse) {
        try {
            ListeCourse listeCourse = listeCourseService.ajouterListeCourse(nouvelleListeCourse);
            return ResponseEntity.ok(listeCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerIngredient(@PathVariable Long id) {
        try {
            // Logique pour supprimer l'ingrédient avec l'ID spécifié
            listeCourseService.supprimerIngredient(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/acheter/{id}")
    public ResponseEntity<Optional<ListeCourse>> acheterIngredient(@PathVariable Long id) {
        Optional<ListeCourse> listeCourse = listeCourseService.acheterIngredient(id);
        return ResponseEntity.ok(listeCourse);
    }

    // Ajoutez cette méthode pour gérer les requêtes OPTIONS
    @RequestMapping(value = "/{idUtilisateur}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptionsRequest() {
        return ResponseEntity.ok().build();
    }
}


