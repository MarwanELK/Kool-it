package project.spring.backend_koolit.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.model.ListeCourseAchete;
import project.spring.backend_koolit.repository.ListeCourseAcheteRepository;
import project.spring.backend_koolit.repository.ListeCourseRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ListeCourseAcheteService {

    private final ListeCourseAcheteRepository listeCourseAcheteRepository;

    @Autowired
    public ListeCourseAcheteService(ListeCourseAcheteRepository listeCourseAcheteRepository) {
        this.listeCourseAcheteRepository = listeCourseAcheteRepository;
    }

    public List<ListeCourseAchete> getAllListesCourse() {
        List<ListeCourseAchete> listesCoursesAchete = listeCourseAcheteRepository.findAll();
        return convertStringIngredientsToList(listesCoursesAchete);
    }

    public List<ListeCourseAchete> getListesCourseByUtilisateur(Long idUtilisateur) {
        List<ListeCourseAchete> listesCoursesAchete  = listeCourseAcheteRepository.findByUtilisateurId(idUtilisateur);
        for(ListeCourseAchete lc : listesCoursesAchete){
            System.out.println(lc.getIngredients());
        }
        return convertStringIngredientsToList(listesCoursesAchete);
    }

    public ListeCourseAchete ajouterListeCourse(Long idUtilisateur, List<String> nouveauxIngredients) {
        String ingredientsAsString = String.join(", ", nouveauxIngredients);
        ListeCourseAchete nouvelleListeCourse = new ListeCourseAchete(idUtilisateur, ingredientsAsString);
        return listeCourseAcheteRepository.save(nouvelleListeCourse);
    }

    // Méthode pour convertir la chaîne d'ingrédients en liste
    private List<ListeCourseAchete> convertStringIngredientsToList(List<ListeCourseAchete> listesCourses) {
        for (ListeCourseAchete listeCourse : listesCourses) {
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


    public ListeCourseAchete ajouterListeCourse(ListeCourseAchete nouvelleListeCourse) {
        return listeCourseAcheteRepository.save(nouvelleListeCourse);}

    public void supprimerIngredient(Long id) {
        listeCourseAcheteRepository.deleteById(id);
    }

    public Optional<ListeCourseAchete> acheterIngredient(Long id){return listeCourseAcheteRepository.findById(id);}

}