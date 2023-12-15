package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import project.spring.backend_koolit.model.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    public void testIngredientGetterSetter() {
        Ingredient ingredient = new Ingredient();

        Long ingredientId = 1L;
        String nom = "Carotte";
        String type = "Legume";  // Utilisation de String au lieu de TypeIngredient

        ingredient.setIngredientId(ingredientId);
        ingredient.setNom(nom);
        ingredient.setType(type);

        assertEquals(ingredientId, ingredient.getIngredientId());
        assertEquals(nom, ingredient.getNom());
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testIngredientToString() {
        Ingredient ingredient = new Ingredient(1L, "Carotte", "Legume");

        assertEquals("1 Carotte Legume", ingredient.toString());
    }
}
