package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.repository.RecetteRepository;
import project.spring.backend_koolit.service.RecetteService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RecetteRepositoryTest {

    @Mock
    private RecetteRepository recetteRepository;

    @InjectMocks
    private RecetteService recetteService;

    @Test
    public void testFindRecetteByRecetteId() {

        Long recetteId = 1L;
        Recette recette = new Recette();
        recette.setRecetteId(recetteId);
        recette.setNom("Recette XYZ");


        when(recetteRepository.findRecetteByRecetteId(recetteId)).thenReturn(recette);


        Recette result = recetteService.findRecetteByRecetteId(recetteId);

        verify(recetteRepository, times(1)).findRecetteByRecetteId(recetteId);


        assertEquals(recetteId, result.getRecetteId());
        assertEquals("Recette XYZ", result.getNom());
    }

    @Test
    public void testFindIngredientByRecetteId() {

        Long recetteId = 1L;
        Recette recette = new Recette();
        recette.setRecetteId(recetteId);
        recette.setNom("Recette XYZ");


        when(recetteRepository.findIngredientByRecetteId(recetteId)).thenReturn(Arrays.asList(recette));


        List<Ingredient> result = recetteService.findIngredientByRecetteId(recetteId);

        verify(recetteRepository, times(1)).findIngredientByRecetteId(recetteId);


        assertEquals(1, result.size());
        assertEquals(recetteId, result.get(0).getIngredientId());
        assertEquals("Recette XYZ", result.get(0).getNom());
    }


}
