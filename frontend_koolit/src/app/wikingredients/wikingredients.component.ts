import { Component, OnInit } from '@angular/core';
import { WikingredientsService } from './wikingredients.service';
import { DomSanitizer } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-wikingredients',
  templateUrl: './wikingredients.component.html',
  styleUrls: ['./styles.css']
})
export class WikingredientsComponent implements OnInit {
  wikingredients: any[] = [];
  wikingredientSelectionne: any | null = null;
  wikingredientSelectionneIndex: number | null = null;
  nomsAliments: string[] = [];
  rechercheComposant: string = '';
  resultatsRecherche: any[] = [];
  wikingredientsFiltres: any[] = [];


  constructor(private wikingredientsService: WikingredientsService, private sanitizer: DomSanitizer) {}

  ngOnInit(): void {
    this.chargerWikingredients();
    this.chargerNomsAliments();
  }

  chargerWikingredients(): void {
    this.wikingredientsService.getAllWikingredients().subscribe(
      (wikingredients) => {
        this.wikingredients = wikingredients;
        console.log('Données de Wikingredients reçues du backend :', wikingredients);
      },
      (error: any) => {
        console.error('Erreur lors du chargement des Wikingredients :', error);
      }
    );
  }
  appliquerFiltre(): void {
    this.wikingredientsService.getAllWikingredients().subscribe(
      (wikingredients) => {
        this.wikingredients = wikingredients.filter(wikingredient => this.correspondRecherche(wikingredient));
      },
      (error: any) => {
        console.error('Erreur lors du chargement des Wikingredients :', error);
      }
    );
  }
  rechercherAliments(): void {
    // Réinitialisez la sélection lorsque vous effectuez une nouvelle recherche
    this.wikingredientSelectionne = null;
    this.wikingredientSelectionneIndex = null;
  
    if (!this.rechercheComposant) {
      // Si la recherche est vide, affiche tout
      this.wikingredientsFiltres = [...this.wikingredients];
    } else {
      // Filtrer la liste des aliments en fonction de rechercheComposant
      this.wikingredientsFiltres = this.wikingredients.filter(wikingredient =>
        this.correspondRecherche(wikingredient)
      );
  
      // Si la liste filtrée n'est pas vide, sélectionnez le premier élément
      if (this.wikingredientsFiltres.length > 0) {
        this.afficherInfoWikingredient(0);
      }
    }
  }
  
  

 chargerNomsAliments(): void {
    this.wikingredientsService.getAllWikingredients().subscribe(
      (wikingredients) => {
        this.wikingredients = wikingredients;
        console.log('Données de Wikingredients reçues du backend :', wikingredients);
      },
      (error: any) => {
        console.error('Erreur lors du chargement des Wikingredients :', error);
      }
    );
  }
  

  decodeJsonString(jsonString: string): any {
    try {
      return JSON.parse(jsonString);
    } catch (error) {
      console.error('Erreur lors du décodage JSON :', error);
      return null;
    }
  }

  afficherInfoWikingredient(index: number): void {
    // Désélectionner si le même aliment est cliqué à nouveau
    if (this.wikingredientSelectionneIndex === index) {
      this.wikingredientSelectionne = null;
      this.wikingredientSelectionneIndex = null;
    } else {
      // Sélectionner le nouvel aliment
      this.wikingredientSelectionne = this.wikingredients[index];
  
      // Décoder les composants si nécessaire
      if (this.wikingredientSelectionne && typeof this.wikingredientSelectionne.composant === 'string') {
        this.wikingredientSelectionne.composant = this.decodeJsonString(this.wikingredientSelectionne.composant);
      }
  
      this.wikingredientSelectionneIndex = index;
    }
  }
  
  
  
  getStars(note: number): number[] {
    return Array.from({ length: Math.round(note) }, (_, index) => index + 1);
  }

  correspondRecherche(wikingredient: any): boolean {
    if (!this.rechercheComposant || this.rechercheComposant.trim() === '') {
      return true; // Si la recherche est vide, affiche tout
    }
  
    // Implémentez la logique de filtrage en fonction de rechercheComposant
    // Vous pouvez ajuster cela en fonction de vos besoins spécifiques
    // Par exemple, vérifiez si le composant existe dans la liste des composants de l'aliment
    return (
      wikingredient.composant &&
      wikingredient.composant.some((composant: any) => composant.nom.toLowerCase().includes(this.rechercheComposant.toLowerCase()))
    );
  }
}
