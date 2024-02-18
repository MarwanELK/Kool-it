package project.spring.backend_koolit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.spring.backend_koolit.model.ListeCourseAchete;
import project.spring.backend_koolit.repository.ListeCourseAcheteRepository;
import project.spring.backend_koolit.service.ListeCourseAcheteService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ListeCourseAcheteServiceTest {

    @Mock
    private ListeCourseAcheteRepository listeCourseAcheteRepository;

    @InjectMocks
    private ListeCourseAcheteService listeCourseAcheteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllListesCourse() {
        // Création de données de test
        ListeCourseAchete listeCourseAchete1 = new ListeCourseAchete(1L, "Farine, Sucre");
        ListeCourseAchete listeCourseAchete2 = new ListeCourseAchete(2L, "Lait, Oeufs");
        List<ListeCourseAchete> listesCourseAchete = Arrays.asList(listeCourseAchete1, listeCourseAchete2);

        // Configuration du comportement simulé du repository
        when(listeCourseAcheteRepository.findAll()).thenReturn(listesCourseAchete);

        // Appel de la méthode à tester
        List<ListeCourseAchete> result = listeCourseAcheteService.getAllListesCourse();

        // Vérification du résultat
        assertEquals(listesCourseAchete, result);
    }

    @Test
    void getListesCourseByUtilisateur() {
        // Création de données de test
        Long idUtilisateur = 1L;
        ListeCourseAchete listeCourseAchete1 = new ListeCourseAchete(1L, "Farine, Sucre");
        ListeCourseAchete listeCourseAchete2 = new ListeCourseAchete(1L, "Lait, Oeufs");
        List<ListeCourseAchete> listesCourseAcheteUtilisateur = Arrays.asList(listeCourseAchete1, listeCourseAchete2);

        // Configuration du comportement simulé du repository
        when(listeCourseAcheteRepository.findByUtilisateurId(idUtilisateur)).thenReturn(listesCourseAcheteUtilisateur);

        // Appel de la méthode à tester
        List<ListeCourseAchete> result = listeCourseAcheteService.getListesCourseByUtilisateur(idUtilisateur);

        // Vérification du résultat
        assertEquals(listesCourseAcheteUtilisateur, result);
    }

    // Ajoutez d'autres tests pour les autres méthodes du service
}
