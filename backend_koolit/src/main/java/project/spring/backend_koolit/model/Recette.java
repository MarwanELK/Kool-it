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

    private static long cpt=0L;

    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recette_id")
    private List<Paire> ingredients; //Liste quantité et nom ingredient

    @ElementCollection
    private List<String> etapesPreparation;

    public Recette() {
    }

    public Recette(String nom) {
        cpt++;
        this.id = cpt;
        this.nom = nom;
        this.ingredients=new ArrayList<>();
        this.etapesPreparation=new ArrayList<>();
    }



    public void afficheRecette(){
        for(Paire p : ingredients){
            System.out.println(p);
        }
    }

    public void ajouterIngredient(Paire p){
        this.ingredients.add(p);
    }

    public List<String> covertStringListIngredient(){
        List<String> liste =  new ArrayList<>();
        for(Paire p : ingredients){
            String ingredient=p.getFst()+p.getSnd();
            liste.add(ingredient);
        }
        return liste;
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

    public List<String> getIngredients() {
        return covertStringListIngredient();
    }

    public List<String> getEtapesPreparation() {
        return etapesPreparation;
    }
}


