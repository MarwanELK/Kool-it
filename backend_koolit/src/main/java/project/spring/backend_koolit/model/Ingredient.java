package project.spring.backend_koolit.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingredient {
    public enum TypeIngredient {
        Legume, Fruit, Viande, Boisson, Céréales, laitier, Poisson, Oeuf, Gras, Sucré
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private TypeIngredient type;

    public Ingredient(){

    }

    public Ingredient(Long id, String nom, TypeIngredient type) {
        this.id = id;
        Nom = nom;
        this.type = type;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public TypeIngredient getType() {
        return type;
    }

    public void setType(TypeIngredient type) {
        this.type = type;
    }
}



