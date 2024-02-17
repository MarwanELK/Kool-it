package project.spring.backend_koolit.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Ville;
import project.spring.backend_koolit.repository.VilleRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class VilleService {
    private final VilleRepository villeRepository;

    @Autowired
    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public Ville getVilleParNom(String nomVille){
        return villeRepository.findByNom(nomVille);
    }

    public Ville getVilleParCoords(double lat, double lng){
        return villeRepository.findByLatAndLng(lat,lng);
    }
}
