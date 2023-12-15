import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.spring.backend_koolit.Controller.MagasinController;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.service.MagasinService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MagasinController.class)
public class MagasinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MagasinService magasinService;

    @Test
    public void testGetAllMagasins() throws Exception {

        Magasin magasin1 = new Magasin( "Magasin 1", "Type1", "https://example.com", "Aliment1");
        Magasin magasin2 = new Magasin( "Magasin 2", "Type2", "https://example2.com", "Aliment2");
        List<Magasin> magasins = Arrays.asList(magasin1, magasin2);

        when(magasinService.getAllMagasins()).thenReturn(magasins);


        mockMvc.perform(get("/magasins"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nom").value("Magasin 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nom").value("Magasin 2"));


        verify(magasinService, times(1)).getAllMagasins();
    }


}
