// liste-de-courses.component.ts
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KoolitService } from './koolit.service';

export interface Ingredient {
  id: number; // Ajoutez cette ligne
  nom: string;
  type: string;
  quantite:number
  ingredients: { nom: string, quantite: number, type: string }[];
  ingredientsList?: { nom: string, quantite:number, type: string }[];
}

@Component({
  selector: 'app-liste-de-courses',
  templateUrl: './liste-de-courses.component.html',
  styleUrls: ['./styles.css']
})
export class ListeDeCoursesComponent implements OnInit {

  nouvelIngredient: Ingredient = { id: 0, nom: '', quantite:0, type: '', ingredients: [] }; // Ajoutez 'id' ici
  listesCourses: Ingredient[] = [];

  constructor(private http: HttpClient, private koolitService: KoolitService) {}

  ngOnInit(): void {
    const utilisateurId = 5;
    this.chargerListeDeCourses(utilisateurId);
  }

  ajouterALaListeDeCourses(): void {
    const nouvelIngredientAEnvoyer = {
      nom: this.nouvelIngredient.nom,
      quantite: this.nouvelIngredient.quantite,
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
        this.chargerListeDeCourses(5); // Fournir l'ID de l'utilisateur ici
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de l\'ingrédient dans la base de données :', error);
      }
    );
  
    // Réinitialisez nouvelIngredient
    this.nouvelIngredient = { id: 0, nom: '', quantite:0, type: '', ingredients: [] };
  }
  

  // Méthode pour charger la liste de courses
  private chargerListeDeCourses(utilisateurId: number): void {
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

  supprimerIngredient(ingredientId: number): void {
    this.koolitService.supprimerIngredient(ingredientId).subscribe(
      () => {
        console.log('Ingrédient supprimé avec succès.');
        // Rafraîchir la liste après la suppression
        this.chargerListeDeCourses(5);
      },
      (error) => {
        console.error('Erreur lors de la suppression de l\'ingrédient :', error);
      }
    );
  }
  
}

