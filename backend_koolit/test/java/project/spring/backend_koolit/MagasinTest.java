package project.spring.backend_koolit.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagasinTest {

    @Test
    public void testGettersAndSetters() {
        // Création d'un objet Magasin
        Magasin magasin = new Magasin();

        // Définition des valeurs
        Long id = 1L;
        String nom = "Magasin test";
        String description = "Description test";
        String typeMagasin = "Type test";
        String urlMagasin = "https://example.com";
        String typeAliment = "Type aliment test";
        List<String> listeTypeAliment = Arrays.asList("Type1", "Type2", "Type3");
        String ville = "Ville test";
        double lat = 10.0;
        double lng = 20.0;
        List<Ingredient> ingredients = new ArrayList<>();

        // Définition des valeurs avec les setters
        magasin.setId(id);
        magasin.setNom(nom);
        magasin.setDescription(description);
        magasin.setTypeMagasin(typeMagasin);
        magasin.setUrlMagasin(urlMagasin);
        magasin.setTypeAliment(typeAliment);
        magasin.setListeTypeAliment(listeTypeAliment);
        magasin.setVille(ville);
        magasin.setLat(lat);
        magasin.setLng(lng);
        magasin.setIngredients(ingredients);

        // Vérification avec les getters
        assertEquals(id, magasin.getId());
        assertEquals(nom, magasin.getNom());
        assertEquals(description, magasin.getDescription());
        assertEquals(typeMagasin, magasin.getTypeMagasin());
        assertEquals(urlMagasin, magasin.getUrlMagasin());
        assertEquals(typeAliment, magasin.getTypeAliment());
        assertEquals(listeTypeAliment, magasin.getListeTypeAliment());
        assertEquals(ville, magasin.getVille());
        assertEquals(lat, magasin.getLat());
        assertEquals(lng, magasin.getLng());
        assertEquals(ingredients, magasin.getIngredients());
    }
}
