package project.spring.backend_koolit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import project.spring.backend_koolit.model.Ville;
import project.spring.backend_koolit.repository.VilleRepository;
import project.spring.backend_koolit.service.VilleService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VilleServiceTest {

    @Mock
    private VilleRepository villeRepository;

    @InjectMocks
    private VilleService villeService;


}
