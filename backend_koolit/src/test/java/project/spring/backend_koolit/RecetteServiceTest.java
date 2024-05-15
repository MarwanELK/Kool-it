package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.repository.RecetteRepository;
import project.spring.backend_koolit.service.RecetteService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RecetteServiceTest {

    @Mock
    private RecetteRepository recetteRepository;

    @InjectMocks
    private RecetteService recetteService;

    @Test
    public void testFindRecetteByRecetteId() {
        // Mocking data
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

        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Carotte");

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);

        recette.setIngredients(ingredients);


        when(recetteRepository.findRecetteByRecetteId(recetteId)).thenReturn(recette);


        List<Ingredient> result = recetteService.findIngredientByRecetteId(recetteId);


        verify(recetteRepository, times(1)).findRecetteByRecetteId(recetteId);

        assertEquals(1, result.size());
        assertEquals("Carotte", result.get(0).getNom());
    }


}
