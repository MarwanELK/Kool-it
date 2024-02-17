package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.spring.backend_koolit.model.Wikingredients;
import project.spring.backend_koolit.repository.WikingredientRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WikingredientRepositoryTest {

    @Autowired
    private WikingredientRepository wikingredientRepository;

    @Test
    void testFindComposantsByNomAliment() {
        String nomAliment = "NomAlimentTest";
        Wikingredients wikingredient = new Wikingredients();
        wikingredient.setNomAliment(nomAliment);
        wikingredient.setComposant("ComposantTest");
        wikingredientRepository.save(wikingredient);

        List<String> composants = wikingredientRepository.findComposantsByNomAliment(nomAliment);
        assertNotNull(composants);
        assertFalse(composants.isEmpty());
    }

    @Test
    void testFindByNomAliment() {
        String nomAliment = "NomAlimentTest";
        Wikingredients wikingredient = new Wikingredients();
        wikingredient.setNomAliment(nomAliment);
        wikingredientRepository.save(wikingredient);

        List<Wikingredients> wikingredients = wikingredientRepository.findByNomAliment(nomAliment);
        assertNotNull(wikingredients);
        assertFalse(wikingredients.isEmpty());
    }

    @Test
    void testFindAllNomAliments() {
        String nomAliment1 = "NomAlimentTest1";
        String nomAliment2 = "NomAlimentTest2";
        wikingredientRepository.save(new Wikingredients(nomAliment1));
        wikingredientRepository.save(new Wikingredients(nomAliment2));

        List<String> nomAliments = wikingredientRepository.findAllNomAliments();
        assertNotNull(nomAliments);
        assertFalse(nomAliments.isEmpty());
        assertTrue(nomAliments.contains(nomAliment1));
        assertTrue(nomAliments.contains(nomAliment2));

    }


}
