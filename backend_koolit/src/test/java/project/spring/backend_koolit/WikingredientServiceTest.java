package project.spring.backend_koolit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import project.spring.backend_koolit.model.Wikingredients;
import project.spring.backend_koolit.service.WikingredientsService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WikingredientsServiceTest {

    @Autowired
    private WikingredientsService wikingredientsService;

    @Test
    void testGetAllWikingredients() {
        List<Wikingredients> wikingredientsList = wikingredientsService.getAllWikingredients();
        // Ajoutez des assertions appropriées en fonction de votre logique métier
        assertTrue(wikingredientsList.size() > 0);
    }

    @Test
    void testGetWikingredientById() {
        Long wikingredientId = 1L; // Remplacez par un ID existant dans votre base de données
        Optional<Wikingredients> wikingredient = wikingredientsService.getWikingredientById(wikingredientId);
        assertTrue(wikingredient.isPresent());
    }

    @Test
    void testGetWikingredientsByNomAliment() {
        String nomAliment = "banane";
        List<Wikingredients> wikingredientsList = wikingredientsService.getWikingredientsByNomAliment(nomAliment);
        assertTrue(wikingredientsList.size() > 0);
    }



}
