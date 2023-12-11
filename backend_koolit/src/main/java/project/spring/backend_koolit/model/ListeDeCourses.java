package project.spring.backend_koolit.model;

import jakarta.persistence.*;
import project.spring.backend_koolit.classUtil.Paire;

import java.util.ArrayList;
import java.util.List;


@Entity
public class ListeDeCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static long cpt=0L;

    //liste de cours qte et nom de l'ingredient
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recette_id")
    public List<Paire> courses;

    public ListeDeCourses() {
        cpt++;
        this.id = cpt;
        courses=new ArrayList<>();
    }

    public List<String> covertStringCourses(){
        List<String> liste =  new ArrayList<>();
        for(Paire p : courses){
            String courses=p.getFst()+p.getSnd();
            liste.add(courses);
        }
        return liste;
    }

    public void ajouterCourse(Paire p){
        courses.add(p);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public List<String> getCourses() {
        return covertStringCourses();
    }

    public void setCourses(List<Paire> courses) {
        this.courses = courses;
    }
}
