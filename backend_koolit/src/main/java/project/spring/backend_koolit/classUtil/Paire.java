package project.spring.backend_koolit.classUtil;

import jakarta.persistence.*;
import project.spring.backend_koolit.model.Recette;

public class Paire<T,U> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static long id;
    private T fst;
    private U snd;
    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    public Paire(T fst, U snd) {
        this.id++;
        this.fst = fst;
        this.snd = snd;
    }
    @Override public String toString() {
        return String.format("(%s %s)",fst.toString(),snd.toString());
    }
}
