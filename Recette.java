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

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
