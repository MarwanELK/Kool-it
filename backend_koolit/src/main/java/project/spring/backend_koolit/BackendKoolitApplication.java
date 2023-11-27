package project.spring.backend_koolit;
import jakarta.el.BeanNameResolver;
import org.springframework.context.ConfigurableApplicationContext;
import project.spring.backend_koolit.classUtil.Paire;
import project.spring.backend_koolit.model.Recette;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.spring.backend_koolit.repository.RecetteRepository;
import java.util.Arrays;

@SpringBootApplication
public class BackendKoolitApplication {

	public static void main(String[] args) {

		// Démarrer l'application Spring Boot
		SpringApplication.run(BackendKoolitApplication.class, args);

	}
}



