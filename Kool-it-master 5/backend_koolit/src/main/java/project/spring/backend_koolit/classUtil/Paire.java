package project.spring.backend_koolit.classUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int fst;
    private String snd;

    public Paire(){

    }

    public Paire(Long id, int fst, String snd) {
        this.id = id;
        this.fst = fst;
        this.snd = snd;
    }
}
