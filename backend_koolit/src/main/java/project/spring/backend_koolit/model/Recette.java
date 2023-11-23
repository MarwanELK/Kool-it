package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import project.spring.backend_koolit.model.Ingredient;

import java.util.List;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recette_id")
    private List<Ingredient> ingredients;

    @ElementCollection
    private List<String> etapesPreparation;

    // Constructeurs, getters, setters, etc.
}


