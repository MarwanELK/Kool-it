package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.spring.backend_koolit.model.ListeCourseAchete;
import project.spring.backend_koolit.repository.ListeCourseAcheteRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ListeCourseAcheteRepositoryTest {

    @Autowired
    private ListeCourseAcheteRepository listeCourseAcheteRepository;

    @Test
    public void testFindByUtilisateurId() {
        // Création d'une liste de courses achetées pour un utilisateur donné
        ListeCourseAchete listeCourseAchete1 = new ListeCourseAchete(1L, "Farine, Sucre");
        ListeCourseAchete listeCourseAchete2 = new ListeCourseAchete(2L, "Lait, Oeufs");
        ListeCourseAchete listeCourseAchete3 = new ListeCourseAchete(1L, "Pommes, Poires");

        // Sauvegarde des listes de courses achetées dans la base de données
        listeCourseAcheteRepository.save(listeCourseAchete1);
        listeCourseAcheteRepository.save(listeCourseAchete2);
        listeCourseAcheteRepository.save(listeCourseAchete3);

        // Recherche des listes de courses achetées pour l'utilisateur 1
        List<ListeCourseAchete> result = listeCourseAcheteRepository.findByUtilisateurId(1L);

        // Vérification que les listes de courses achetées ont été trouvées
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(liste -> liste.getUtilisateurId().equals(1L)));
    }

    @Test
    public void testFindById() {
        // Création d'une liste de courses achetées
        ListeCourseAchete listeCourseAchete = new ListeCourseAchete(1L, "Farine, Sucre");

        // Sauvegarde de la liste de courses achetées dans la base de données
        ListeCourseAchete savedListeCourseAchete = listeCourseAcheteRepository.save(listeCourseAchete);

        // Recherche de la liste de courses achetées par son ID
        Optional<ListeCourseAchete> result = listeCourseAcheteRepository.findById(savedListeCourseAchete.getId());

        // Vérification que la liste de courses achetées a été trouvée
        assertTrue(result.isPresent());
        assertEquals(savedListeCourseAchete, result.get());
    }
}
