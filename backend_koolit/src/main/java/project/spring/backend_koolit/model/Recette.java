package project.spring.backend_koolit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recette {
    @Id
    private long id;
    private String nom;
    private String listeIngredients;

    private String etapesPreparation;

    public Recette() {
    }


    public Recette(long id, String nom) {
        super();
        this.id = id;
        this.nom = nom;
        this.listeIngredients = "";
        this.etapesPreparation ="";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getListeIngredients() {
        return listeIngredients;
    }

    public void setListeIngredients(String listeIngredients) {
        this.listeIngredients = listeIngredients;
    }

    public String getEtapesPreparation() {
        return etapesPreparation;
    }

    public void setEtapesPreparation(String etapesPreparation) {
        this.etapesPreparation = etapesPreparation;
    }
}


