package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import project.spring.backend_koolit.classUtil.Paire;
import project.spring.backend_koolit.model.Ingredient;

import java.util.List;

@Entity
@Table(name = "recettetest")
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recetteId;
@Column (name = "nom")
    private String nom;

    @ManyToMany
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
   private List<Ingredient> ingredients;

    @ElementCollection
    private List<String> etapesPreparation;


    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}


