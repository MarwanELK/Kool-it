package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.repository.IngredientRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DataJpaTest
@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class IngredientRepositoryTest {

    @Mock
    private IngredientRepository ingredientRepository;


    @Test
    public void testFindByNom() {

        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Carotte");


        when(ingredientRepository.findByNom("Carotte")).thenReturn(ingredient);



        verify(ingredientRepository, times(1)).findByNom("Carotte");


    }
}
