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

    @Column(name = "nom")
    private String nom;

    @Column(name = "quantite")
    private int quantite;



    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeIngredient type;

    public Ingredient(long l, String carotte, TypeIngredient typeIngredient) {

    }

    public enum TypeIngredient {
        Legume, Fruit, Viande, Boisson, Céréales, Laitier, Poisson, Oeuf, Gras, Sucré, Viennoiserie, Pain, Pâtisserie
    }


    public Ingredient() {
    }

    public Ingredient(Long ingredientId, String nom, int quantite, TypeIngredient type) {
        this.ingredientId = ingredientId;
        this.nom = nom;
        this.quantite = quantite;
        this.type = type;
    }



    public int getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", type=" + type +
                '}';
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

}
