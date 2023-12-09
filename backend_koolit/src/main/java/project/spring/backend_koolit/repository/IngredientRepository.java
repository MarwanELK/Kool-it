package project.spring.backend_koolit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.spring.backend_koolit.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByNom(String nom);
}
