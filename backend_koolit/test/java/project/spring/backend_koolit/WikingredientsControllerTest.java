package project.spring.backend_koolit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import project.spring.backend_koolit.model.Wikingredients;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WikingredientsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllWikingredients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/wikingredients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testGetWikingredientById() throws Exception {
        Long wikingredientId = 1L; // Remplacez par un ID existant dans votre base de données
        mockMvc.perform(MockMvcRequestBuilders.get("/wikingredients/{id}", wikingredientId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testAjouterWikingredient() throws Exception {
        Wikingredients wikingredient = new Wikingredients(); // Remplacez par un objet Wikingredients valide
        String jsonRequest = objectMapper.writeValueAsString(wikingredient);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/wikingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        // Ajoutez des assertions appropriées en fonction de votre logique métier
    }

    @Test
    void testSupprimerWikingredient() throws Exception {
        Long wikingredientId = 1L; // Remplacez par un ID existant dans votre base de données
        mockMvc.perform(MockMvcRequestBuilders.delete("/wikingredients/{id}", wikingredientId))
                .andExpect(status().isOk());
    }

    // Ajoutez d'autres méthodes de test en fonction des fonctionnalités de votre contrôleur

}

