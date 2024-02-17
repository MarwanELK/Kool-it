package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import project.spring.backend_koolit.model.Magasin;

import static org.junit.jupiter.api.Assertions.*;

public class MagasinTest {

    @Test
    public void testMagasinGetterSetter() {

        Magasin magasin = new Magasin();


        Long id = 1L;
        String nom = "Supermarché XYZ";
        String typeMagasin = "Supermarché";
        String urlMagasin = "http://supermarche-xyz.com";
        String typeAliment = "Épicerie";

        magasin.setId(id);
        magasin.setNom(nom);
        magasin.setTypeMagasin(typeMagasin);
        magasin.setUrlMagasin(urlMagasin);
        magasin.setTypeAliment(typeAliment);


        assertEquals(id, magasin.getId());
        assertEquals(nom, magasin.getNom());
        assertEquals(typeMagasin, magasin.getTypeMagasin());
        assertEquals(urlMagasin, magasin.getUrlMagasin());
        assertEquals(typeAliment, magasin.getTypeAliment());
    }

    @Test
    public void testMagasinConstructor() {

        String nom = "Supermarché XYZ";
        String typeMagasin = "Supermarché";
        String urlMagasin = "http://supermarche-xyz.com";
        String typeAliment = "Épicerie";

        Magasin magasin = new Magasin(nom, typeMagasin, urlMagasin, typeAliment);


        assertNull(magasin.getId());
        assertEquals(nom, magasin.getNom());
        assertEquals(typeMagasin, magasin.getTypeMagasin());
        assertEquals(urlMagasin, magasin.getUrlMagasin());
        assertEquals(typeAliment, magasin.getTypeAliment());
    }
}
