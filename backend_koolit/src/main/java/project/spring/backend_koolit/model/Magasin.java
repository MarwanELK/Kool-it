package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import project.spring.backend_koolit.classUtil.Paire;
import java.util.List;


@Entity
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Magasin() {
        this.id=0L;
    }
}
