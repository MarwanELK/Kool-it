package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Table(name = "commentaire")
public class Commentaire {

    @Id
    @Column(name = "commentaire_id")
    private Long commentaireId;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "texte")
    private String texte;

    public Commentaire() {
    }

    public Commentaire(Long commentaireId, String auteur, String texte) {
        this.commentaireId = commentaireId;
        this.auteur = auteur;
        this.texte = texte;
    }

    public Long getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Long commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String toString() {
        return commentaireId + " " + auteur + " " + texte;
    }
}

