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
    @Column(name="nom")
    private String nom;

    @Column(name="description")
    private String description;
    @Column(name = "type_magasin")
    private String typeMagasin;
    @Column(name = "url_magasin")
    private String urlMagasin;

    @Column(name = "type_aliment")
    private String typeAliment;

    @Column(name="ville")
    private String ville;

    @Column(name = "latitude")
    private double lat;
    @Column(name = "longitude")
    private double lng;

    public Magasin() {
        // Constructeur par défaut nécessaire pour JPA
    }



    public Magasin(Long id, String nom, String description, String typeMagasin, String urlMagasin, String typeAliment, String ville, double lat, double lng) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.typeMagasin = typeMagasin;
        this.urlMagasin = urlMagasin;
        this.typeAliment = typeAliment;
        this.ville = ville;
        this.lat = lat;
        this.lng = lng;
    }

    // Getters et setters


    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
