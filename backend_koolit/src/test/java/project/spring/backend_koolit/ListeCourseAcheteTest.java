package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.spring.backend_koolit.model.ListeCourseAchete;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ListeCourseAcheteTest {

    @Test
    public void testGetterSetter() {
        // Création d'une instance de ListeCourseAchete
        ListeCourseAchete listeCourseAchete = new ListeCourseAchete();
        listeCourseAchete.setId(1L);
        listeCourseAchete.setUtilisateurId(2L);
        listeCourseAchete.setIngredients("Farine, Sucre, Oeufs");

        // Vérification des getters
        assertEquals(1L, listeCourseAchete.getId());
        assertEquals(2L, listeCourseAchete.getUtilisateurId());
        assertEquals("Farine, Sucre, Oeufs", listeCourseAchete.getIngredients());

        // Vérification des setters
        listeCourseAchete.setId(3L);
        listeCourseAchete.setUtilisateurId(4L);
        listeCourseAchete.setIngredients("Lait, Beurre");
        assertEquals(3L, listeCourseAchete.getId());
        assertEquals(4L, listeCourseAchete.getUtilisateurId());
        assertEquals("Lait, Beurre", listeCourseAchete.getIngredients());
    }

    @Test
    public void testIngredientsList() {
        // Création d'une instance de ListeCourseAchete
        ListeCourseAchete listeCourseAchete = new ListeCourseAchete();
        listeCourseAchete.setIngredientsList(Arrays.asList("Farine", "Sucre", "Oeufs"));

        // Vérification de la conversion de la liste d'ingrédients en chaîne
        assertEquals("Farine, Sucre, Oeufs", listeCourseAchete.getIngredients());

        // Vérification de la conversion de la chaîne en liste d'ingrédients
        List<String> ingredientsList = listeCourseAchete.getIngredientsList();
        assertNotNull(ingredientsList);
        assertEquals(3, ingredientsList.size());
        assertEquals("Farine", ingredientsList.get(0));
        assertEquals("Sucre", ingredientsList.get(1));
        assertEquals("Oeufs", ingredientsList.get(2));
    }
}
