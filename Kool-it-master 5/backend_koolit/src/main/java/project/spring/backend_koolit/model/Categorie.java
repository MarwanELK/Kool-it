package project.spring.backend_koolit.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public enum Categorie {
    Boucherie,
    Poissonerie,
    Primeur,
    Supermarché,
    Hypermarché,
    Superette,
    Alimentation_Générale,
    Epiecreie,
    Boulangerie;
}
