package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.repository.ListeCourseRepository;
import project.spring.backend_koolit.service.ListeCourseService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ListeCourseServiceTest {

    @Mock
    private ListeCourseRepository listeCourseRepository;

    @InjectMocks
    private ListeCourseService listeCourseService;

    @Test
    public void testGetAllListesCourse() {
        // Mocking data
        ListeCourse listeCourse1 = new ListeCourse(1L, "ingredient1, ingredient2");
        ListeCourse listeCourse2 = new ListeCourse(2L, "ingredient3, ingredient4");
        List<ListeCourse> mockedListesCourses = Arrays.asList(listeCourse1, listeCourse2);

        when(listeCourseRepository.findAll()).thenReturn(mockedListesCourses);


        List<ListeCourse> result = listeCourseService.getAllListesCourse();


        verify(listeCourseRepository, times(1)).findAll();


        assertEquals("ingredient1", result.get(0).getIngredientsList().get(0));
        assertEquals("ingredient2", result.get(0).getIngredientsList().get(1));
        assertEquals("ingredient3", result.get(1).getIngredientsList().get(0));
        assertEquals("ingredient4", result.get(1).getIngredientsList().get(1));
    }

}
