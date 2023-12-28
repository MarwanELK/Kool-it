package project.spring.backend_koolit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "ville")
public class Ville {
    @Id
    private Long villeId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "latitude")
    private double lat;

    @Column(name = "longitude")
    private double lng;

    public Ville() {
    }

    public Ville(Long villeId, String nom, double lat, double lng) {
        this.villeId = villeId;
        this.nom = nom;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getVilleId() {
        return villeId;
    }

    public void setVilleId(Long villeId) {
        this.villeId = villeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
}

