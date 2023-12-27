// liste-de-courses.component.ts
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KoolitService } from './koolit.service';
import { saveAs } from 'file-saver';
;


export interface Ingredient {
  id: number; // Ajoutez cette ligne
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

  nouvelIngredient: Ingredient = { id: 0, nom: '', type: '', ingredients: [] }; // Ajoutez 'id' ici
  listesCourses: Ingredient[] = [];
  selectedFormat: string = 'csv';

  constructor(private http: HttpClient, private koolitService: KoolitService) {}

  ngOnInit(): void {
    const utilisateurId = 5;
    this.chargerListeDeCourses(utilisateurId);
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
        this.chargerListeDeCourses(5); // Fournir l'ID de l'utilisateur ici
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de l\'ingrédient dans la base de données :', error);
      }
    );
  
    // Réinitialisez nouvelIngredient
    this.nouvelIngredient = { id: 0, nom: '', type: '', ingredients: [] };
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
  telechargerListeCSV(): void {
    const csvData = this.convertToCSV(this.listesCourses);
    const blob = new Blob([csvData], { type: 'text/csv;charset=utf-8' });
    saveAs(blob, 'liste_courses.csv');
  }

  private convertToCSV(data: Ingredient[]): string {
    const header = 'nom,type\n';
    const csv = data
      .map(
        (row) =>
          `"${this.formatIngredientsList(row.ingredientsList)}"\n`
      )
      .join('');
    return header + csv;
  }
  
  private formatIngredientsList(ingredientsList: { nom: string; type: string }[] | undefined): string {
    if (!ingredientsList) {
      return '';
    }
    return ingredientsList
      .map(ingredient => `${ingredient.nom} ${ingredient.type}`)
      .join(', ');
  }
  
  telechargerListeNote(): void {
    const noteData = this.convertToNoteFormat(this.listesCourses);
    const blob = new Blob([noteData], { type: 'text/plain;charset=utf-8' });
    saveAs(blob, 'liste_courses_note.txt');
  }
  telechargerListe(): void {
    if (this.selectedFormat === 'csv') {
      this.telechargerListeCSV();
    } else if (this.selectedFormat === 'note') {
      this.telechargerListeNote();
    }
  }
  private convertToNoteFormat(data: Ingredient[]): string {
    return data
      .map(
        (row) =>
          `${this.formatNomType(row)}\n`
      )
      .join('');
  }
  
  private formatNomType(row: Ingredient): string {
    const nom = row.ingredientsList?.[0]?.nom || '';
    const type = row.ingredientsList?.[0]?.type || '';
    return `${nom} ${type}`;
  }


  
}

