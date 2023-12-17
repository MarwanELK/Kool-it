package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Table(name = "magasin")
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "type_magasin")
    private String typeMagasin;
    @Column(name = "url_magasin")
    private String urlMagasin;

    @Column(name = "type_aliment")
    private String typeAliment;

    public Magasin() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Magasin(String nom, String typeMagasin, String urlMagasin, String typeAliment) {
        this.nom = nom;
        this.typeMagasin = typeMagasin;
        this.urlMagasin = urlMagasin;
        this.typeAliment = typeAliment;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeMagasin() {
        return typeMagasin;
    }

    public void setTypeMagasin(String typeMagasin) {
        this.typeMagasin = typeMagasin;
    }

    public String getUrlMagasin() {
        return urlMagasin;
    }

    public void setUrlMagasin(String urlMagasin) {
        this.urlMagasin = urlMagasin;
    }

    public String getTypeAliment() {
        return typeAliment;
    }

    public void setTypeAliment(String typeAliment) {
        this.typeAliment = typeAliment;
    }
}
