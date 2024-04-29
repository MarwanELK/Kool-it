package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class RecetteTest {
    @Test
    public void testRecetteIngredients() {
        // Créer une instance de Recette
        Recette recette = new Recette();

        // Créer une liste d'ingrédients
        List<Ingredient> ingredients = Arrays.asList(

        );

        // Définir la liste d'ingrédients pour la recette
        recette.setIngredients(ingredients);

        // Vérifier que la liste d'ingrédients est correctement définie
        assertEquals(ingredients, recette.getIngredients());
    }


}
