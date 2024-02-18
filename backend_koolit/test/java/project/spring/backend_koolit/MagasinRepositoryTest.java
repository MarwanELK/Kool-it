package project.spring.backend_koolit.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.spring.backend_koolit.model.Magasin;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MagasinRepositoryTest {

    @Autowired
    private MagasinRepository magasinRepository;

    @Test
    public void testFindByNom() {
        // Création d'un magasin et sauvegarde dans la base de données
        Magasin magasin = new Magasin();
        magasin.setNom("Magasin test");
        magasin.setDescription("Description test");
        magasin.setTypeMagasin("Type test");
        magasin.setVille("Ville test");
        magasin.setLat(10.0);
        magasin.setLng(20.0);
        magasinRepository.save(magasin);

        // Recherche du magasin par nom
        Optional<Magasin> optionalMagasin = magasinRepository.findByNom("Magasin test");

        // Vérification si le magasin est trouvé
        assertTrue(optionalMagasin.isPresent());

        // Vérification des détails du magasin
        Magasin foundMagasin = optionalMagasin.get();
        assertEquals("Magasin test", foundMagasin.getNom());
        assertEquals("Description test", foundMagasin.getDescription());
        assertEquals("Type test", foundMagasin.getTypeMagasin());
        assertEquals("Ville test", foundMagasin.getVille());
        assertEquals(10.0, foundMagasin.getLat());
        assertEquals(20.0, foundMagasin.getLng());
    }

    @Test
    public void testFindMagasinsByVille() {
        // Création de plusieurs magasins et sauvegarde dans la base de données
        Magasin magasin1 = new Magasin();
        magasin1.setNom("Magasin 1");
        magasin1.setVille("Ville test");
        magasinRepository.save(magasin1);

        Magasin magasin2 = new Magasin();
        magasin2.setNom("Magasin 2");
        magasin2.setVille("Ville test");
        magasinRepository.save(magasin2);

        Magasin magasin3 = new Magasin();
        magasin3.setNom("Magasin 3");
        magasin3.setVille("Autre ville");
        magasinRepository.save(magasin3);

        // Recherche des magasins par ville
        List<Magasin> magasins = magasinRepository.findMagasinsByVille("Ville test");

        // Vérification du nombre de magasins trouvés
        assertEquals(2, magasins.size());
    }

    // Ajoutez d'autres tests pour les autres méthodes du repository selon vos besoins
}
