
package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @Column(name = "ingredient_id")
    private Long ingredientId;
    @Column(name = "quantite")
    private int quantite;

    @Column(name = "nom")
    private String nom;

    @Enumerated(EnumType.STRING)
    private TypeIngredient type;

    public Integer getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public enum TypeIngredient {
        Extrait, Legume, Fruit, Viande, Boisson, Céréales, Laitier, Poisson, Oeuf, Gras, Sucré,Tablette, Sec, Frais, Doux, Fruits, Épice, Poudre, Tablettes, Liquide;
    }


    public Ingredient() {
    }

    public Ingredient(Long ingredientId, String nom, TypeIngredient type) {
        this.ingredientId = ingredientId;
        this.nom = nom;
        this.type = type;
    }

    // Méthodes Getter et Setter pour 'ingredientId'

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    // Méthodes Getter et Setter pour 'nom'

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthodes Getter et Setter pour 'type'

    public TypeIngredient getType() {
        return type;
    }

    public void setType(TypeIngredient type) {
        this.type = type;
    }

    // Méthode toString

    public String toString() {
        return ingredientId + " " + nom + " " + type;
    }
}
