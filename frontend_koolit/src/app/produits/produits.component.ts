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
}
