package project.spring.backend_koolit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.spring.backend_koolit.service.EvenementRecetteService;
import project.spring.backend_koolit.service.RecetteEvent;
import project.spring.backend_koolit.service.GoogleAuthService;


import java.util.List;
import java.util.Map;

@Controller
public class CalendarController {

    @Autowired
    private GoogleAuthService googleAuthService;

    @Autowired
    public EvenementRecetteService evenementRecette;

    @GetMapping("/export-calendar")
    public String exportCalendar() {
        return "redirect:" + googleAuthService.getAuthorizationUrl();
    }

    @GetMapping("/oauth2callback")
    public String oauth2Callback(@RequestParam("code") String code) {
        String accessToken = googleAuthService.getAccessToken(code);
        if (accessToken != null) {
            return "redirect:/export-success";
        } else {
            return "redirect:/export-failure";
        }
    }


    @PostMapping("/insert-event")
    @ResponseBody
    public String insertEvent(@RequestBody Map<String, String> requestData) {
        String code = requestData.get("code");
        String personId = requestData.get("personId");
        System.out.println("Code: " + code);
        System.out.println("Person ID: " + personId);

        if (code != null && personId != null) {
            String accessToken = googleAuthService.getAccessToken(code);
            if (accessToken != null) {

                List<RecetteEvent> RecetteEvents = evenementRecette.getRecettes(Integer.parseInt(personId));
                System.out.println("Evenement recette:");
                if (!RecetteEvents.isEmpty()) {
                    for (RecetteEvent event : RecetteEvents) {
                        System.out.println(event.getDate() + " " + event.getHeure() + " " + event.getTitre());
                        // Insérer cet événement dans Google Calendar
                        String eventId = googleAuthService.insertEvent(accessToken, event.getTitre(), event.getDate(), event.getHeure());
                        if (eventId != null) {
                            System.out.println("Événement inséré avec succès avec l'ID : " + eventId);
                        } else {
                            System.out.println("Échec de l'insertion de l'événement");
                        }
                    }
                } else {
                    System.out.println("Aucun événement à insérer.");
                }

                return "Événements insérés avec succès pour la personne : " + personId;
            } else {
                return "Échec de l'obtention de l'access token";
            }
        } else {
            return "Paramètres manquants dans la requête";
        }
    }

}