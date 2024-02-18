package project.spring.backend_koolit.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.spring.backend_koolit.model.Ingredient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void testFindByNom() {
        // Création d'un ingrédient et sauvegarde dans la base de données
        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Ingredient test");
        ingredientRepository.save(ingredient);

        // Recherche de l'ingrédient par nom
        Ingredient foundIngredient = ingredientRepository.findByNom("Ingredient test");

        // Vérification si l'ingrédient est trouvé
        assertNotNull(foundIngredient);

        // Vérification des détails de l'ingrédient
        assertEquals("Ingredient test", foundIngredient.getNom());
    }

    @Test
    public void testFindByIngredientId() {
        // Création d'un ingrédient et sauvegarde dans la base de données
        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Ingredient test");
        Ingredient savedIngredient = ingredientRepository.save(ingredient);

        // Recherche de l'ingrédient par ID
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(savedIngredient.getIngredientId());

        // Vérification si l'ingrédient est trouvé
        assertTrue(optionalIngredient.isPresent());

        // Vérification des détails de l'ingrédient
        Ingredient foundIngredient = optionalIngredient.get();
        assertEquals("Ingredient test", foundIngredient.getNom());
    }

    // Ajoutez d'autres tests pour les autres méthodes du repository selon vos besoins
}
