// produits.component.ts
import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { KoolitService } from '../liste-de-courses/koolit.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {
  recettes: any[] = [];
  listesDeCourses: any[] = []; // Ajoutez la déclaration de la propriété ici

  constructor(private recetteService: RecetteService, private koolitService: KoolitService) { }
  

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

  ajouterIngredientsALaListe(ingredients: any[]): void {
    const utilisateurId = 5;
    this.koolitService.ajouterIngredientAListeCourse(utilisateurId, ingredients).subscribe(
      (response: any) => {
        console.log('Ingrédients ajoutés avec succès à la liste de courses :', response);
      },
      (error) => {
        console.error('Erreur lors de l\'ajout des ingrédients à la liste de courses :', error);
      }
    );
  }
}
