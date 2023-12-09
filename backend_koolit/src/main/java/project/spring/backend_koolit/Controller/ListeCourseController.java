package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.repository.ListeCourseRepository;
import project.spring.backend_koolit.service.ListeCourseService;

import java.util.Arrays;
import java.util.List;
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



}