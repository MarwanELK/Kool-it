package project.spring.backend_koolit;

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




}
