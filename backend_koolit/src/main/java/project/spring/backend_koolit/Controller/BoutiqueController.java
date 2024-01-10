package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Boutique;
import project.spring.backend_koolit.service.BoutiqueService;

import java.util.List;

@RestController
@RequestMapping("/boutiques")
public class BoutiqueController {

    @Autowired
    private BoutiqueService boutiqueService;

    @GetMapping
    public List<Boutique> getAllBoutiques() {
        return boutiqueService.getAllBoutiques();
    }

    @GetMapping("/{id}")
    public Boutique getBoutiqueById(@PathVariable Long id) {
        return boutiqueService.getBoutiqueById(id);
    }

    @PostMapping
    public Boutique saveBoutique(@RequestBody Boutique boutique) {
        return boutiqueService.saveBoutique(boutique);
    }

    @DeleteMapping("/{id}")
    public void deleteBoutique(@PathVariable Long id) {
        boutiqueService.deleteBoutique(id);
    }
}
