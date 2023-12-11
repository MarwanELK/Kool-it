package project.spring.backend_koolit;
import jakarta.el.BeanNameResolver;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.context.ConfigurableApplicationContext;
import project.spring.backend_koolit.classUtil.Paire;
import project.spring.backend_koolit.model.ListeDeCourses;
import project.spring.backend_koolit.model.Recette;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.spring.backend_koolit.repository.ListeDeCoursesRepository;
import project.spring.backend_koolit.repository.RecetteRepository;
import java.util.Arrays;

@SpringBootApplication
public class BackendKoolitApplication {

	public static void main(String[] args) {

		// Démarrer l'application Spring Boot
		ConfigurableApplicationContext context=SpringApplication.run(BackendKoolitApplication.class, args);

		RecetteRepository recetteRepository = context.getBean(RecetteRepository.class);

		ListeDeCoursesRepository listeDeCoursesRepository = context.getBean(ListeDeCoursesRepository.class);

		Recette recette1 = new Recette("Entree");
		recette1.setNom("Soupe de carottes, lait de coco et gingembre");
		recette1.ajouterIngredient(new Paire(100,"Ingredient1"));
		recette1.ajouterIngredient(new Paire(200, "Ingredient2"));

		Recette recette2 = new Recette("Plat");
		recette2.setNom("Pâtes à la feta et aux tomates au four");
		recette2.ajouterIngredient(new Paire(100,"Ingredient1"));
		recette2.ajouterIngredient(new Paire(200, "Ingredient2"));

		Recette recette3 = new Recette("Dessert");
		recette3.setNom("Fondants au chocolat cœur au chocolat blanc");
		recette3.ajouterIngredient(new Paire(100,"(g) Chocolat noir  Fin Carré"));
		recette3.ajouterIngredient(new Paire(100, "(g) Chocolat blanc  Fin Carré"));
		recette3.ajouterIngredient(new Paire(2," Oeufs"));
		recette3.ajouterIngredient(new Paire(30, "(g) Sucre  Navarre"));
		recette3.ajouterIngredient(new Paire(50,"(g) Beurre  Envia"));
		recette3.ajouterIngredient(new Paire(2, "(c. à s.) Farine  Navarre"));
		recette3.getEtapesPreparation().add("Préchauffer le four à 260°C (thermostat 9)");
		recette3.getEtapesPreparation().add(" Faire fondre les 100 g de chocolat noir et le beurre au bain-marie");
		recette3.getEtapesPreparation().add(" Dans un grand bol, mélanger les œufs entiers et le sucre, Ajouter petit à petit 2 c-à-s de farine, Incorporer le chocolat et mélanger vigoureusement");
		recette3.getEtapesPreparation().add(" Beurrer et fariner les ramequins puis verser un tiers de la préparation dans le fond");
		recette3.getEtapesPreparation().add(" Déposer 1 carré de chocolat blanc dans chaque ramequin, puis recouvrir avec le reste de la préparation");
		recette3.getEtapesPreparation().add(" Cuire 7 minutes au four.");

		// Enregistrez les recettes dans la base de données en utilisant la méthode saveAll héritée
		recetteRepository.saveAll(Arrays.asList(recette1, recette2, recette3));

		// Affichez un message pour indiquer que les recettes ont été ajoutées
		System.out.println("Trois recettes ont été ajoutées à la base de données.");

		ListeDeCourses liste1 = new ListeDeCourses();
		ListeDeCourses liste2 = new ListeDeCourses();
		ListeDeCourses liste3 = new ListeDeCourses();

		for(Paire p : recette3.mesIngredients()){
			liste1.ajouterCourse(p);
		}


		listeDeCoursesRepository.saveAll(Arrays.asList(liste1,liste2,liste3));

	}
}



