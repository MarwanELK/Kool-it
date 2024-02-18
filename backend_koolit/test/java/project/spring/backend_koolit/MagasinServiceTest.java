package project.spring.backend_koolit.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.repository.MagasinRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class MagasinServiceTest {

    @Mock
    private MagasinRepository magasinRepository;

    @InjectMocks
    private MagasinService magasinService;

    public MagasinServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllMagasins() {
        // Création d'une liste de magasins fictive
        List<Magasin> magasins = new ArrayList<>();
        magasins.add(new Magasin());
        magasins.add(new Magasin());

        // Configuration du comportement du repository mocké
        when(magasinRepository.findAll()).thenReturn(magasins);

        // Appel de la méthode à tester
        List<Magasin> result = magasinService.getAllMagasins();

        // Vérification du résultat
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    // Ajoutez d'autres tests pour les autres méthodes de MagasinService en fonction de vos besoins
}
