package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import project.spring.backend_koolit.model.Ingredient;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    @Test
    public void testIngredientGetterSetter() {

        Ingredient ingredient = new Ingredient();


        Long ingredientId = 1L;
        String nom = "Carotte";
        Ingredient.TypeIngredient type = Ingredient.TypeIngredient.Legume;

        ingredient.setIngredientId(ingredientId);
        ingredient.setNom(nom);
        ingredient.setType(type);


        assertEquals(ingredientId, ingredient.getIngredientId());
        assertEquals(nom, ingredient.getNom());
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testIngredientToString() {

        Ingredient ingredient = new Ingredient(1L, "Carotte", Ingredient.TypeIngredient.Legume);


        assertEquals("1 Carotte Legume", ingredient.toString());
    }
}