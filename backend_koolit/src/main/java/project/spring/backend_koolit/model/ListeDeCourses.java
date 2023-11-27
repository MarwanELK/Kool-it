package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import project.spring.backend_koolit.classUtil.Paire;

import java.util.List;


@Entity
public class ListeDeCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //liste de cours qte et nom de l'ingredient
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recette_id")
    public List<Paire> courses;

    public ListeDeCourses() {
        this.id=0L;
    }
}
