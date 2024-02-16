import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VilleTest {

    @Test
    void testGetSetVilleId() {
        // Arrange
        Ville ville = new Ville();
        Long villeId = 1L;

        // Act
        ville.setVilleId(villeId);

        // Assert
        assertEquals(villeId, ville.getVilleId());
    }

    @Test
    void testGetSetNom() {
        // Arrange
        Ville ville = new Ville();
        String nom = "Paris";

        // Act
        ville.setNom(nom);

        // Assert
        assertEquals(nom, ville.getNom());
    }

    @Test
    void testGetSetLat() {
        // Arrange
        Ville ville = new Ville();
        double lat = 48.8566;

        // Act
        ville.setLat(lat);

        // Assert
        assertEquals(lat, ville.getLat());
    }

    @Test
    void testGetSetLng() {
        // Arrange
        Ville ville = new Ville();
        double lng = 2.3522;

        // Act
        ville.setLng(lng);

        // Assert
        assertEquals(lng, ville.getLng());
    }

    @Test
    void testEquality() {
        // Arrange
        Ville ville1 = new Ville(1L, "Paris", 48.8566, 2.3522);
        Ville ville2 = new Ville(1L, "Paris", 48.8566, 2.3522);
        Ville ville3 = new Ville(2L, "Londres", 51.509865, -0.118092);

        // Act & Assert
        assertEquals(ville1, ville2);
        assertNotEquals(ville1, ville3);
    }

    @Test
    void testHashCode() {
        // Arrange
        Ville ville1 = new Ville(1L, "Paris", 48.8566, 2.3522);
        Ville ville2 = new Ville(1L, "Paris", 48.8566, 2.3522);

        // Act & Assert
        assertEquals(ville1.hashCode(), ville2.hashCode());
    }
}
