package project.spring.backend_koolit.model;
import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    public enum TypeIngredient {
        Legume, Fruit, Viande, Boisson, Céréales, laitier, Poisson, Oeuf, Gras, Sucré
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;
    @Column(name = "nom")
    private String Nom;
    private TypeIngredient type;
    public String toString()
    {
        return ingredientId + " " + Nom + " " + type;
    }
    public Ingredient(){

    }

    public Ingredient(Long id, String nom, TypeIngredient type) {
        this.ingredientId = id;
        Nom = nom;
        this.type = type;
    }
}



