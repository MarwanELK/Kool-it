package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import project.spring.backend_koolit.model.ListeCourse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class ListeCourseTest {

    @Test
    public void testListeCourseGetterSetter() {

        ListeCourse listeCourse = new ListeCourse();


        Long id = 1L;
        Long utilisateurId = 2L;
        String ingredients = "Carotte, Pomme, Poisson";

        listeCourse.setId(id);
        listeCourse.setUtilisateurId(utilisateurId);
        listeCourse.setIngredients(ingredients);


        assertEquals(id, listeCourse.getId());
        assertEquals(utilisateurId, listeCourse.getUtilisateurId());
        assertEquals(ingredients, listeCourse.getIngredients());
    }

    @Test
    public void testListeCourseIngredientsList() {

        ListeCourse listeCourse = new ListeCourse();


        List<String> ingredientsList = Arrays.asList("Carotte", "Pomme", "Poisson");


        listeCourse.setIngredientsList(ingredientsList);


        assertEquals(ingredientsList, listeCourse.getIngredientsList());
    }

    @Test
    public void testListeCourseConstructor() {

        Long utilisateurId = 2L;
        String ingredients = "Carotte, Pomme, Poisson";

        ListeCourse listeCourse = new ListeCourse(utilisateurId, ingredients);


        assertNull(listeCourse.getId());
        assertEquals(utilisateurId, listeCourse.getUtilisateurId());
        assertEquals(ingredients, listeCourse.getIngredients());
    }
}
