// liste-de-courses.component.ts
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KoolitService } from './koolit.service';


export interface Ingredient {
  nom: string;
  type: string;
  ingredients: { nom: string, type: string }[];
  ingredientsList?: { nom: string, type: string }[];
}

@Component({
  selector: 'app-liste-de-courses',
  templateUrl: './liste-de-courses.component.html',
  styleUrls: ['./styles.css']
})
export class ListeDeCoursesComponent implements OnInit {

  nouvelIngredient: Ingredient = { nom: '', type: '', ingredients: [] };
  listesCourses: Ingredient[] = [];

  constructor(private http: HttpClient, private koolitService: KoolitService) {}


// liste-de-courses.component.ts
ngOnInit(): void {
  const utilisateurId = 5;
  this.koolitService.getListeDeCourses(utilisateurId).subscribe(
    (listeCoursesData: any[]) => {
      console.log('Données de la liste de courses reçues du backend :', listeCoursesData);
      this.listesCourses = listeCoursesData.map((course) => {
        course.ingredientsList = JSON.parse(course.ingredients);
        return course;
      });
    },
    (error) => {
      console.error('Erreur lors de la récupération de la liste de courses :', error);
    }
  );
}



ajouterALaListeDeCourses(): void {
  const nouvelIngredientAEnvoyer = {
    nom: this.nouvelIngredient.nom,
    type: this.nouvelIngredient.type,
  };

  const nouvelleListe = {
    utilisateurId: 5, 
    ingredients: JSON.stringify([nouvelIngredientAEnvoyer]),
  };

  this.koolitService.ajouterIngredient(5, nouvelleListe).subscribe(
    (response: any) => {
      console.log('Ingrédient ajouté avec succès dans la base de données:', response);

      // Rafraîchir la liste après l'ajout
      this.chargerListeDeCourses();
    },
    (error) => {
      console.error('Erreur lors de l\'ajout de l\'ingrédient dans la base de données :', error);
    }
  );

  // Réinitialisez nouvelIngredient
  this.nouvelIngredient = { nom: '', type: '', ingredients: [] };
}

ajouterIngredientsALaListe(ingredients: Ingredient[]): void {
  const utilisateurId = 5;

  // Créez un tableau d'ingrédients à ajouter à la liste de courses
  const ingredientsAEnvoyer = {
    nom: this.nouvelIngredient.nom,
    type: this.nouvelIngredient.type,
  };

  const nouvelleListe = {
    utilisateurId:5,
    ingredients: JSON.stringify(ingredientsAEnvoyer),
  };

  this.koolitService.ajouterIngredient(utilisateurId, nouvelleListe).subscribe(
    (response: any) => {
      console.log('Ingrédients ajoutés avec succès dans la base de données:', response);

      // Rafraîchir la liste après l'ajout
      this.chargerListeDeCourses();
    },
    (error) => {
      console.error('Erreur lors de l\'ajout des ingrédients dans la base de données :', error);
    }
  );
}

// Méthode pour charger la liste de courses
private chargerListeDeCourses(): void {
  const utilisateurId = 5;
  this.koolitService.getListeDeCourses(utilisateurId).subscribe(
    (listeCoursesData: any[]) => {
      console.log('Données de la liste de courses reçues du backend :', listeCoursesData);
      this.listesCourses = listeCoursesData.map((course) => {
        course.ingredientsList = JSON.parse(course.ingredients);
        return course;
      });
    },
    (error) => {
      console.error('Erreur lors de la récupération de la liste de courses :', error);
    }
  );
}
}