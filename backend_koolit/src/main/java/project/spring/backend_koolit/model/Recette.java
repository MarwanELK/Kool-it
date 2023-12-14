package project.spring.backend_koolit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "recettetest")
public class Recette {

    @Id
    private Long recetteId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nbPersonnes")
    private Integer nbPersonnes=4;

    @Column(name = "note")
    private double note;
    @ElementCollection
    private List<Double> notes;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;

    @Column(name = "image")
    private String photoPath;

    @ElementCollection
    private List<String> etapesPreparation;

    @JsonIgnoreProperties("recettes")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getRecetteId() {
        return recetteId;
    }

    public void setRecetteId(Long recetteId) {
        this.recetteId = recetteId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getEtapesPreparation() {
        return etapesPreparation;
    }

    public void setEtapesPreparation(List<String> etapesPreparation) {
        this.etapesPreparation = etapesPreparation;
    }
    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public List<Double> getNotes() {
        return notes;
    }

    public void setNotes(List<Double> notes) {
        this.notes = notes;
    }

    public Integer getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(Integer nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }
}
