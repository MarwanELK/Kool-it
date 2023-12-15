package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.spring.backend_koolit.model.ListeCourse;
import project.spring.backend_koolit.repository.ListeCourseRepository;
import project.spring.backend_koolit.service.ListeCourseService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DataJpaTest
@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class ListeCourseRepositoryTest {

    @Mock
    private ListeCourseRepository listeCourseRepository;

    @InjectMocks
    private ListeCourseService listeCourseService;

    @Test
    public void testFindByUtilisateurId() {

        Long idUtilisateur = 1L;
        ListeCourse listeCourse1 = new ListeCourse();
        listeCourse1.setUtilisateurId(idUtilisateur);
        ListeCourse listeCourse2 = new ListeCourse();
        listeCourse2.setUtilisateurId(idUtilisateur);

        when(listeCourseRepository.findByUtilisateurId(idUtilisateur)).thenReturn(Arrays.asList(listeCourse1, listeCourse2));


        List<ListeCourse> result = listeCourseRepository.findByUtilisateurId(idUtilisateur);

        verify(listeCourseRepository, times(1)).findByUtilisateurId(idUtilisateur);


        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getUtilisateurId()).isEqualTo(idUtilisateur);
        assertThat(result.get(1).getUtilisateurId()).isEqualTo(idUtilisateur);
    }
}
