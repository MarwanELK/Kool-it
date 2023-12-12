// produits.component.ts
import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service'; // Assurez-vous que le chemin est correct

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {
  recettes: any[] = [];

  constructor(private recetteService: RecetteService) {}

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
}
