import { Component, OnInit } from '@angular/core';
import { WikingredientsService } from './wikingredients.service';
import { DomSanitizer } from '@angular/platform-browser';
import { Location } from '@angular/common';

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
  resultatsAffiches: boolean = false;
  afficherInformationsNutritionnelles: boolean = false;


  constructor(private wikingredientsService: WikingredientsService, private sanitizer: DomSanitizer) {
    this.resultatsAffiches = false;
    
  }

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
  

  
  correspondRecherche(wikingredient: any): boolean {
    if (!this.rechercheComposant || this.rechercheComposant.trim() === '') {
      return true; // Si la recherche est vide, affiche tout
    }
  
    // Vérifiez d'abord si wikingredient et wikingredient.composant sont définis
    if (wikingredient && wikingredient.composant) {
      // Si wikingredient.composant est un tableau, recherchez dans les composants
      if (Array.isArray(wikingredient.composant)) {
        return wikingredient.composant.some((composant: any) =>
          composant && composant.nom && composant.nom.toLowerCase().includes(this.rechercheComposant.toLowerCase())
        );
      }
      // Si wikingredient.composant n'est pas un tableau, recherchez dans le composant lui-même
      return wikingredient.composant.nom && wikingredient.composant.nom.toLowerCase().includes(this.rechercheComposant.toLowerCase());
    }
  
    // Si wikingredient ou wikingredient.composant n'est pas défini, ne correspond pas à la recherche
    return false;
  }
  
  
  chargerNomsAliments(): void {
    this.wikingredientsService.getAllWikingredients().subscribe(
      (wikingredients) => {
        // Mettez à jour les noms d'aliments sans écraser les données initiales
        this.nomsAliments = wikingredients.map(wikingredient => wikingredient.nomAliment);
        console.log('Noms d\'aliments chargés :', this.nomsAliments);
      },
      (error: any) => {
        console.error('Erreur lors du chargement des noms d\'aliments :', error);
      }

    );
};
  
  

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
  
  

  isWikingredientSelected(index: number): boolean {
    return this.wikingredientSelectionne !== null && this.wikingredientSelectionneIndex === index;
  }

  hasComposants(wikingredient: any): boolean {
    return wikingredient?.composant && wikingredient.composant.length > 0;
  }

  isArrayAndNotEmpty(array: any[]): boolean {
    return Array.isArray(array) && array.length > 0;
  }

}
