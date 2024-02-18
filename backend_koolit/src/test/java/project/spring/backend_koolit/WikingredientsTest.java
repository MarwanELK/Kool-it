package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import project.spring.backend_koolit.model.Wikingredients;

import static org.junit.jupiter.api.Assertions.*;

public class WikingredientsTest {

    @Test
    void testConstructorAndGettersSetters() {
        Wikingredients wikingredient = new Wikingredients(1L, "Pomme", "Vitamine C", 4.5);

        assertEquals(1L, wikingredient.getAlimentId());
        assertEquals("Pomme", wikingredient.getNomAliment());
        assertEquals("Vitamine C", wikingredient.getComposant());
        assertEquals(4.5, wikingredient.getNote());

        wikingredient.setAlimentId(2L);
        wikingredient.setNomAliment("Orange");
        wikingredient.setComposant("Fibres");
        wikingredient.setNote(3.8);

        assertEquals(2L, wikingredient.getAlimentId());
        assertEquals("Orange", wikingredient.getNomAliment());
        assertEquals("Fibres", wikingredient.getComposant());
        assertEquals(3.8, wikingredient.getNote());
    }


}
