// produits.component.ts
import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { KoolitService } from './koolit.service';


@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {
  recettes: any[] = [];

  constructor(private recetteService: RecetteService, private koolitService: KoolitService) {}

  ngOnInit(): void {
    this.recetteService.getRecettes().subscribe(
      (data: any) => {
        console.log('Données de recettes reçues du backend :', data);
        this.recettes = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération des recettes :', error);
      }
    );
  }

  ajouterALaListeDeCourses(ingredient: any): void {
   
    const ingredientAEnvoyer = {
      nom: ingredient.nom,
      quantite: ingredient.quantite,
      type: ingredient.type,
    };
  
    const nouvelleListe = {
      utilisateurId: 5,  
      ingredients: JSON.stringify([ingredientAEnvoyer]),
    };
  
    this.koolitService.ajouterIngredient(5, nouvelleListe).subscribe(
      (response: any) => {
        console.log('Ingrédient ajouté avec succès dans la base de données :', response);
       
        this.chargerListeDeCourses(5); 
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de l\'ingrédient dans la base de données :', error);
      }
    );
  }
  ajouterTousALaListeDeCourses(recette: any): void {
    for (const ingredient of recette.ingredients) {
      this.ajouterALaListeDeCourses(ingredient);
    }
  }
  trierParNote(): void {
    this.recettes.sort((a, b) => b.note - a.note);
  }
 
  private chargerListeDeCourses(utilisateurId: number): void {
    this.koolitService.getListeDeCourses(utilisateurId).subscribe(
      (listeCoursesData: any[]) => {
        console.log('Données de la liste de courses reçues du backend :', listeCoursesData);
        
      },
      (error) => {
        console.error('Erreur lors de la récupération de la liste de courses :', error);
      }
    );
  }
  noterRecette(recette: any, note: number): void {
    this.recetteService.noterRecette(recette.recetteId, note).subscribe(
      (recetteNotee: any) => {
        console.log('Recette notée avec succès :', recetteNotee);
        // Rafraîchissez les données si nécessaire
        this.chargerListeDeCourses(5); // Assurez-vous d'ajuster cela en fonction de votre logique
      },
      (error: any) => { // Ajouter un type pour 'error'
        console.error('Erreur lors de la notation de la recette :', error);
      }
    );
}

augmenterPart(recette : any, personnesEnPlus:any):void{
  this.recetteService.augmenterPart(recette.recetteId, recette.personnesEnPlus).subscribe(
    (recetteNotee: any) => {
      console.log('Nombre de personnes augmenté avec succès :', recetteNotee);
      // Rafraîchissez les données si nécessaire
      this.chargerListeDeCourses(5); // Assurez-vous d'ajuster cela en fonction de votre logique
    },
    (error: any) => { // Ajouter un type pour 'error'
      console.error('Erreur lors de l augmentation du nombre de personne :', error);
    }
  );
}

}