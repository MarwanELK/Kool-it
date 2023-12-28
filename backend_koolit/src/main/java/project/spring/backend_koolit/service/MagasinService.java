package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.repository.MagasinRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagasinService {

    private final MagasinRepository magasinRepository;

    @Autowired
    public MagasinService(MagasinRepository magasinRepository) {
        this.magasinRepository = magasinRepository;
    }

    public List<Magasin> getAllMagasins() {
        return magasinRepository.findAll();
    }

    public Magasin getMagasinById(Long id) {
        return magasinRepository.findById(id).orElse(null);
    }

    public Magasin ajouterMagasin(Magasin magasin) {
        return magasinRepository.save(magasin);
    }

    public Magasin modifierMagasin(Long id, Magasin magasin) {
        Magasin magasinExistant = magasinRepository.findById(id).orElse(null);

        if (magasinExistant != null) {
            // Mettez à jour les propriétés du magasinExistant avec celles du magasin passé en paramètre
            magasinExistant.setNom(magasin.getNom());
            magasinExistant.setTypeMagasin(magasin.getTypeMagasin());
            magasinExistant.setUrlMagasin(magasin.getUrlMagasin());
            magasinExistant.setTypeAliment(magasin.getTypeAliment());

            // Enregistrez les modifications dans la base de données
            return magasinRepository.save(magasinExistant);
        } else {
            // Gérez le cas où le magasin n'est pas trouvé
            return null;
        }
    }

    public void supprimerMagasin(Long id) {
        magasinRepository.deleteById(id);
    }

    public List<Magasin> rechercherMagasinParNom(String nom) {
        return magasinRepository.findByNomContainingIgnoreCase(nom);
    }

    public Magasin getMagasinByNom(String nom) {
        return magasinRepository.findByNom(nom).orElse(null);
    }

    public List<Magasin> rechercherMagasinsParVille(String ville){
        return magasinRepository.findMagasinsByVille(ville);
    }
}
