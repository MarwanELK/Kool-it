package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.repository.ListeCourseRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ListeCourseService {

    private final ListeCourseRepository listeCourseRepository;

    @Autowired
    public ListeCourseService(ListeCourseRepository listeCourseRepository) {
        this.listeCourseRepository = listeCourseRepository;
    }

    public List<ListeCourse> getAllListesCourse() {
        List<ListeCourse> listesCourses = listeCourseRepository.findAll();
        return convertStringIngredientsToList(listesCourses);
    }

    public List<ListeCourse> getListesCourseByUtilisateur(Long idUtilisateur) {
        List<ListeCourse> listesCourses = listeCourseRepository.findByUtilisateurId(idUtilisateur);
        for(ListeCourse lc : listesCourses){
            System.out.println(lc.getIngredients());
        }
        return convertStringIngredientsToList(listesCourses);
    }

    public ListeCourse ajouterListeCourse(Long idUtilisateur, List<String> nouveauxIngredients) {
        String ingredientsAsString = String.join(", ", nouveauxIngredients);
        ListeCourse nouvelleListeCourse = new ListeCourse(idUtilisateur, ingredientsAsString);
        return listeCourseRepository.save(nouvelleListeCourse);
    }

    // Méthode pour convertir la chaîne d'ingrédients en liste
    private List<ListeCourse> convertStringIngredientsToList(List<ListeCourse> listesCourses) {
        for (ListeCourse listeCourse : listesCourses) {
            if (listeCourse.getIngredients() != null) {
                String[] ingredientsArray = listeCourse.getIngredients().split(", ");
                listeCourse.setIngredientsList(Arrays.asList(ingredientsArray));
            } else {
                // Traitement pour une chaîne d'ingrédients nulle, si nécessaire
                listeCourse.setIngredientsList(Collections.emptyList());
            }
        }
        return listesCourses;
    }


    public ListeCourse ajouterListeCourse(ListeCourse nouvelleListeCourse) {
        return listeCourseRepository.save(nouvelleListeCourse);}

    public void supprimerIngredient(Long id) {
        listeCourseRepository.deleteById(id);
    }
}






