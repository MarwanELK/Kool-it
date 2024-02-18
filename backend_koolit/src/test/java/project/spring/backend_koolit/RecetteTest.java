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
    public void testRecetteGetterSetter() {
        // Créer une instance de Recette
        Recette recette = new Recette();

        // Définir des valeurs pour les propriétés
        Long recetteId = 1L;
        String nom = "Recette XYZ";
        double note = 4.5;
        List<Double> notes = Arrays.asList(4.0, 5.0, 4.5);
        List<String> etapesPreparation = Arrays.asList("Étape 1", "Étape 2");

        recette.setRecetteId(recetteId);
        recette.setNom(nom);
        recette.setNote(note);
        recette.setNotes(notes);
        recette.setEtapesPreparation(String.valueOf(etapesPreparation));

        // Vérifier les valeurs à l'aide des getters
        assertEquals(recetteId, recette.getRecetteId());
        assertEquals(nom, recette.getNom());
        assertEquals(note, recette.getNote());
        assertEquals(notes, recette.getNotes());
        assertEquals(etapesPreparation, recette.getEtapesPreparation());
    }

    @Test
    public void testRecetteIngredients() {
        // Créer une instance de Recette
        Recette recette = new Recette();

        // Créer une liste d'ingrédients
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient(1L, "Carotte", Ingredient.TypeIngredient.Legume),
                new Ingredient(2L, "Pomme", Ingredient.TypeIngredient.Fruit)
        );

        // Définir la liste d'ingrédients pour la recette
        recette.setIngredients(ingredients);

        // Vérifier que la liste d'ingrédients est correctement définie
        assertEquals(ingredients, recette.getIngredients());
    }

    @Test
    public void testRecetteConstructor() {
        // Créer une instance de Recette en utilisant le constructeur
        Long recetteId = 1L;
        String nom = "Recette XYZ";
        double note = 4.5;
        List<Double> notes = Arrays.asList(4.0, 5.0, 4.5);
        List<String> etapesPreparation = Arrays.asList("Étape 1", "Étape 2");

        Recette recette = new Recette();
        recette.setRecetteId(recetteId);
        recette.setNom(nom);
        recette.setNote(note);
        recette.setNotes(notes);
        recette.setEtapesPreparation(String.valueOf(etapesPreparation));

        // Vérifier que les propriétés sont correctement définies
        assertEquals(recetteId, recette.getRecetteId());
        assertEquals(nom, recette.getNom());
        assertEquals(note, recette.getNote());
        assertEquals(notes, recette.getNotes());
        assertEquals(etapesPreparation, recette.getEtapesPreparation());
    }
}
