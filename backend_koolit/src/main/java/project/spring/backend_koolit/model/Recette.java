package project.spring.backend_koolit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "recette")
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "recette_commentaire",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "commentaire_id")
    )
    private List<Commentaire> commentaires;

    @Column(name = "image")
    private String photoPath;




    @Column(name = "etapePrepa")
    private String etapesPreparation;

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

    public String getEtapesPreparation() {
        return etapesPreparation;
    }

    public void setEtapesPreparation(String etapesPreparation) {
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
        for(Ingredient i : ingredients){
            if(i.getQuantite()==0) {
                i.setQuantite(1);
            }
            double newQTE=(i.getQuantite()/this.nbPersonnes*nbPersonnes);
            i.setQuantite((int)newQTE);
        }
        this.nbPersonnes = nbPersonnes;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
