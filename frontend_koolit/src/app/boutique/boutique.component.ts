// boutique.component.ts

import { Component, OnInit } from '@angular/core';
import { BoutiqueService } from './boutique.service';

@Component({
  selector: 'app-boutique',
  templateUrl: './boutique.component.html',
  styleUrls: ['./boutique.component.css']
})
export class BoutiqueComponent implements OnInit {
  articles: any[] = [];  // Remplacez 'any' par le type réel de vos articles

  constructor(private boutiqueService: BoutiqueService) {}

  ngOnInit(): void {
    const boutiqueId = 1;  // Remplacez cela par l'ID de votre boutique
    this.boutiqueService.getArticlesByBoutique(boutiqueId).subscribe(
      (response: any) => {
        this.articles = response;
        console.log('Articles récupérés avec succès :', this.articles);
      },
      (error) => {
        console.error('Erreur lors de la récupération des articles :', error);
      }
    );
  }
}
