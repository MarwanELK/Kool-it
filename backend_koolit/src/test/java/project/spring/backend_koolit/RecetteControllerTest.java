package project.spring.backend_koolit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.spring.backend_koolit.Controller.RecetteController;
import project.spring.backend_koolit.model.Ingredient;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.service.RecetteService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecetteController.class)
public class RecetteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RecetteService recetteService;

    @Test
    public void testGetAllRecettes() throws Exception {

        Recette recette1 = new Recette();
        recette1.setRecetteId(1L);
        recette1.setNom("Recette 1");
        recette1.setNote(4.5);

        Recette recette2 = new Recette();
        recette2.setRecetteId(2L);
        recette2.setNom("Recette 2");
        recette2.setNote(3.8);

        List<Recette> recettes = Arrays.asList(recette1, recette2);


        when(recetteService.getAllRecettes()).thenReturn(recettes);


        mockMvc.perform(get("/recettes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].recetteId").value(1L))
                .andExpect(jsonPath("$[0].nom").value("Recette 1"))
                .andExpect(jsonPath("$[0].note").value(4.5))
                .andExpect(jsonPath("$[1].recetteId").value(2L))
                .andExpect(jsonPath("$[1].nom").value("Recette 2"))
                .andExpect(jsonPath("$[1].note").value(3.8));


        verify(recetteService, times(1)).getAllRecettes();
    }

    @Test
    public void testFindIngredientByRecetteId() throws Exception {

        Recette recette = new Recette();
        recette.setRecetteId(1L);
        recette.setNom("Recette Test");
        recette.setNote(4.2);

        when(recetteService.findRecetteByRecetteId(1L)).thenReturn(recette);

        mockMvc.perform(get("/recettes/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.recetteId").value(1L))
                .andExpect(jsonPath("$.nom").value("Recette Test"))
                .andExpect(jsonPath("$.note").value(4.2));


        verify(recetteService, times(1)).findRecetteByRecetteId(1L);
    }


}