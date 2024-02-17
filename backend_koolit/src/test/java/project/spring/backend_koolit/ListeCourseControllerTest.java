package project.spring.backend_koolit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.spring.backend_koolit.Controller.ListeCourseController;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.service.ListeCourseService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ListeCourseController.class)
public class ListeCourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ListeCourseService listeCourseService;

    @Test
    public void testGetAllListesCourses() throws Exception {

        ListeCourse listeCourse1 = new ListeCourse(1L, "Course 1");
        ListeCourse listeCourse2 = new ListeCourse(2L, "Course 2");
        List<ListeCourse> listeCourses = Arrays.asList(listeCourse1, listeCourse2);


        when(listeCourseService.getAllListesCourse()).thenReturn(listeCourses);


        mockMvc.perform(get("/liste-course"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nom").value("Course 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nom").value("Course 2"));


        verify(listeCourseService, times(1)).getAllListesCourse();
    }


}
