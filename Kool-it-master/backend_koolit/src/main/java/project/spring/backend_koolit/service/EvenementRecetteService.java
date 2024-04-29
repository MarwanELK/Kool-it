package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.repository.RecetteRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@Service
public class EvenementRecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    public List<RecetteEvent> getRecettes(Integer idRecette) {
        List<Object[]> recetteDetails = recetteRepository.findRecetteDetail(idRecette);
        List<RecetteEvent> recetteEvents = new ArrayList<>();

        for (Object[] recetteDetail : recetteDetails) {
            LocalDate date = ((Date) recetteDetail[0]).toLocalDate();
            LocalTime heure = ((Time) recetteDetail[1]).toLocalTime();
            String recetteName = (String) recetteDetail[2];
            RecetteEvent event = new RecetteEvent(date, heure, recetteName);
            recetteEvents.add(event);
        }

        return recetteEvents;
    }
}
