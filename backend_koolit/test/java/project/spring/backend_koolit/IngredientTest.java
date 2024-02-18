package project.spring.backend_koolit.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class IngredientTest {

    @Test
    public void testIngredientConstructor() {
        // Créer des données de test
        Long ingredientId = 1L;
        String nom = "Nom de l'ingrédient";
        int quantite = 100;
        Ingredient.TypeIngredient type = Ingredient.TypeIngredient.Legume;

        // Créer une instance de la classe Ingredient en utilisant le constructeur
        Ingredient ingredient = new Ingredient(ingredientId, nom, quantite, type);

        // Vérifier que l'instance a été créée avec succès
        assertNotNull(ingredient);
        assertEquals(ingredientId, ingredient.getIngredientId());
        assertEquals(nom, ingredient.getNom());
        assertEquals(quantite, ingredient.getQuantite());
        assertEqua
