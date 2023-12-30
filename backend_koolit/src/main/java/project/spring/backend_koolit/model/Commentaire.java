package project.spring.backend_koolit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @Column(name = "commentaireId")
    private Long commentaireId;

    @Column(name = "username")
    private String username;

    @Column(name = "contenu")
    private String contenu;

    public Long getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Long commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
