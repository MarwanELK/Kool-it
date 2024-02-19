package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Table(name = "liste_courseAchete")
public class ListeCourseAchete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "utilisateur_id")
    private Long utilisateurId;

    @Column(name = "ingredients")
    private String ingredients;

    @Transient
    @Column(name = "ingredients")
    private List<String> ingredientsList;

    public ListeCourseAchete() {
    }

    public ListeCourseAchete(Long utilisateurId, String ingredients) {
        this.utilisateurId = utilisateurId;
        this.ingredients = ingredients;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    // Getters et Setters pour la nouvelle liste d'ingrédients
    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
}