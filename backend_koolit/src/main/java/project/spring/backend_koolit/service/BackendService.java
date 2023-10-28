package project.spring.backend_koolit.service;

import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Recette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BackendService {
    static private ArrayList<Recette> recettes= new ArrayList<>(Arrays.asList(
            new Recette(1,"Tarte au pomme"),
            new Recette(2,"lasagne"),
            new Recette(3,"cookie"),
            new Recette(4,"pizza napolitaine"),
            new Recette(5,"soupe aux pois"),
            new Recette(6, "brownie")
    ));

    public List<Recette> getRecettes(){
        return recettes;
    }

    public Recette getRecette(long id) {
        return recettes.stream().filter(recette -> recette.getId()== id).findFirst().orElse(null);
    }

    public void deleteRecette(long id) {
        recettes.removeIf(car -> car.getId() == id);
    }


    public void addRecette(Recette recette) {
        recettes.add(recette);
    }

    public void updateRecette(Recette recette, long id) {
        recettes.forEach(r1 ->{
            if(r1.getId()==id){
                recettes.set(recettes.indexOf(r1), recette);
            }
        });
    }
}
