
import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  recettes: any[] = [];

  constructor(private recetteService: RecetteService) {}

  ngOnInit(): void {
    this.recetteService.getRecettes().subscribe(
      (data: any) => {
        console.log('Données de recettes reçues du backend :', data);
        this.recettes = data;
        this.filtrerTopRecettes(); // Appel de la méthode de filtrage des meilleures recettes
      },
      (error) => {
        console.error('Erreur lors de la récupération des recettes :', error);
      }
    );
  }

  // Méthode pour filtrer les deux meilleures recettes par note
  filtrerTopRecettes(): void {
    // Triez les recettes par note de la plus haute à la plus basse
    this.recettes.sort((a, b) => b.note - a.note);

    // Gardez seulement les deux premières recettes (les mieux notées)
    this.recettes = this.recettes.slice(0, 3);
  }
}
