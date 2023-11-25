package project.spring.backend_koolit.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Magasin {

    private String adresse;
    private String nom;
    private Categorie type ;

    Magasin (String adresse, String nom, Categorie type){
        this.adresse=adresse;
        this.nom= nom;
        this.type = type;
    }
    Magasin(){}

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getType() {
        return type;
    }

    public void setType(Categorie type) {
        this.type = type;
    }

}
