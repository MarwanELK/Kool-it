import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface RecetteData {
  nom: string;
  ingredients: { nom: string, type: string }[];
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  recetteData: RecetteData | undefined;
  title = 'KoolIt';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<RecetteData>('http://localhost:8080/recettes/1').subscribe(
      (data) => {
        console.log('Données reçues du backend :', data);
        this.recetteData = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération de la recette:', error);
      }
    );
  }

  getNomIngredient(index: number): string {
    // Assurez-vous que recetteData et recetteData.ingredients ne sont pas nuls
    if (this.recetteData && this.recetteData.ingredients && index < this.recetteData.ingredients.length) {
      return this.recetteData.ingredients[index].nom;
    }
    return '';
  }
}
