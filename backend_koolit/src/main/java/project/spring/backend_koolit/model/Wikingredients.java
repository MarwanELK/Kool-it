package project.spring.backend_koolit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Table(name = "Wikingredients")

public class Wikingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="alimentId")
    private Long alimentId;
    @Column(name = "nom_aliment")
    private String nomAliment;

    @Column(name = "composant")
    private String composant;


    @Column(name = "note")
    private double note;
    public Wikingredients() {
    }
    public Wikingredients(String nomAliment) {
        this.nomAliment=nomAliment;
    }

    public Wikingredients(Long alimentId, String nomAliment, String composant,  double note) {
        this.alimentId = alimentId;
        this.nomAliment = nomAliment;
        this.composant = composant;
        this.note = note;
    }

    public Long getAlimentId() {
        return alimentId;
    }

    public void setAlimentId(Long alimentId) {
        this.alimentId = alimentId;
    }

    public String getNomAliment() {
        return nomAliment;
    }

    public void setNomAliment(String nomAliment) {
        this.nomAliment = nomAliment;
    }

    public String getComposant() {
        return composant;
    }

    public void setComposant(String composant) {
        this.composant = composant;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }





}