package project.spring.backend_koolit.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MagasinTest {

    @Test
    public void testMagasinConstructor() {
        // Créer des données de test
        Long id = 1L;
        String nom = "Nom du magasin";
        String description = "Description du magasin";
        String typeMagasin = "Type du magasin";
        String urlMagasin = "URL du magasin";
        String typeAliment = "Type d'aliment";
        String ville = "Ville du magasin";
        double lat = 123.456;
        double lng = 456.789;
        List<Ingredient> ingredients = new ArrayList<>();

        // Créer une instance de la classe Magasin en utilisant le constructeur
        Magasin magasin = new Magasin(id, nom, description, typeMagasin, urlMagasin, typeAliment, ville, lat, lng, ingredients);

        // Vérifier que l'instance a été créée avec succès
        assertNotNull(magasin);
        assertEquals(id, magasin.getId());
        assertEquals(nom, magasin.getNom());
        assertEquals(description, magasin.getDescription());
        assertEquals
