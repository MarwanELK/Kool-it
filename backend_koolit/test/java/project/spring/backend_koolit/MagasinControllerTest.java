package project.spring.backend_koolit.Controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.spring.backend_koolit.model.Magasin;
import project.spring.backend_koolit.service.MagasinService;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MagasinController.class)
@AutoConfigureMockMvc
public class MagasinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MagasinService magasinService;

    @Test
    public void testGetAllMagasins() throws Exception {
        // Mocking the service
        List<Magasin> mockMagasins = Collections.emptyList();
        when(magasinService.getAllMagasins()).thenReturn(mockMagasins);

        // Performing the request and verifying the response
        mockMvc.perform(get("/magasins")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetMagasinsProximite() throws Exception {
        // Mocking the service
        List<Magasin> mockMagasins = Collections.emptyList();
        when(magasinService.parseMagasinsFromJson(anyString())).thenReturn(mockMagasins);

        // Performing the request and verifying the response
        mockMvc.perform(get("/magasins/magasins-proximite")
                        .param("latitude", "48.8566")
                        .param("longitude", "2.3522")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    // Add more tests for other controller methods as needed
}
