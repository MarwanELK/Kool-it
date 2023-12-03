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

    public Paire(int fst, String snd) {
        this.id=0L;
        this.fst = fst;
        this.snd = snd;
    }

    public int getFst() {
        return fst;
    }

    public String getSnd() {
        return snd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFst(int fst) {
        this.fst = fst;
    }

    public void setSnd(String snd) {
        this.snd = snd;
    }
}
