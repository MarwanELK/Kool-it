package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.ListeDeCourses;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.repository.ListeDeCoursesRepository;
import project.spring.backend_koolit.repository.RecetteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackendService {
   @Autowired
    private RecetteRepository recetteRepository;
  @Autowired
   private ListeDeCoursesRepository listeDeCoursesRepository;

    public List<ListeDeCourses> getListeDeCourses(){
        List<ListeDeCourses> listesDeCourses = new ArrayList<>();
        listeDeCoursesRepository.findAll().forEach(liste -> {
            listesDeCourses.add(liste);
        });
        return listesDeCourses;
    }

    public List<Recette> getRecettes(){
        List<Recette> recettes = new ArrayList<>();
        recetteRepository.findAll().forEach(recette -> {
            recettes.add(recette);
        });
        return recettes;
    }

    public Recette getRecette(long id) {
        return recetteRepository.findById(id).orElse(null);
    }

    public void deleteRecette(long id) {
        recetteRepository.deleteById(id);
    }


    public void addRecette(Recette recette) {
        recetteRepository.save(recette);
    }

    public void updateRecette(Recette recette, long id) {
        recetteRepository.save(recette);
    }
}
