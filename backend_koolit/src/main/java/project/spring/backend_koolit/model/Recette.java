package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import project.spring.backend_koolit.classUtil.Paire;
import project.spring.backend_koolit.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recette_id")
    private List<Paire> ingredients;

    @ElementCollection
    private List<String> etapesPreparation;

    public Recette() {
    }





    public void afficheRecette(){
        for(Paire p : ingredients){
            System.out.println(p);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIngredients(List<Paire> ingredients) {
        this.ingredients = ingredients;
    }

    public void setEtapesPreparation(List<String> etapesPreparation) {
        this.etapesPreparation = etapesPreparation;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Paire> getIngredients() {
        return ingredients;
    }

    public List<String> getEtapesPreparation() {
        return etapesPreparation;
    }
}


