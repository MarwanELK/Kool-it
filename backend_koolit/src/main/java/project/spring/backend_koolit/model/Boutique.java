package project.spring.backend_koolit.model;

import jakarta.persistence.*;

import java.util.List;

// Boutique.java
@Entity
@Table(name = "boutiques")
public class Boutique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "boutique", cascade = CascadeType.ALL)
    private List<Article> articles;

    // Constructeurs

    public Boutique() {
    }

    public Boutique(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
