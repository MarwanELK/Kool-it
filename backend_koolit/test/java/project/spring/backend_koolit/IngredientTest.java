package project.spring.backend_koolit.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    public void testGetterAndSetter() {
        // Création d'un ingrédient
        Ingredient ingredient = new Ingredient();

        // Définition des valeurs
        Long ingredientId = 1L;
        String nom = "Pomme";
        int quantite = 5;
        Ingredient.TypeIngredient type = Ingredient.TypeIngredient.Fruit;

        // Définition des valeurs avec les setters
        ingredient.setIngredientId(ingredientId);
        ingredient.setNom(nom);
        ingredient.setQuantite(quantite);
        ingredient.setType(type);

        // Vérification avec les getters
        assertEquals(ingredientId, ingredient.getIngredientId());
        assertEquals(nom, ingredient.getNom());
        assertEquals(quantite, ingredient.getQuantite());
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testToString() {
        // Création d'un ingrédient
        Ingredient ingredient = new Ingredient(1L, "Pomme", 5, Ingredient.TypeIngredient.Fruit);

        // Vérification du toString()
        assertEquals("Ingredient{ingredientId=1, nom='Pomme', quantite=5, type=Fruit}", ingredient.toString());
    }
}
