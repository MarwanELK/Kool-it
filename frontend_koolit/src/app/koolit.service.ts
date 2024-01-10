import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import { Article } from './boutique/article.model';
@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  private apiUrl = "http://localhost:8080"

  readonly ENDPOINT_RECETTES ="/recettes"
  constructor(private httpClient : HttpClient) { 

  }
  getListeDeCourses(utilisateurId: number): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.apiUrl}/liste-course/${utilisateurId}`).pipe(
      map((data: any[]) => {
        return data.map(ingredient => ({
          nom: ingredient.nom,
          type: ingredient.type,
          ingredientsList: JSON.parse(ingredient.ingredients)
        }));
      }),
      catchError((error: any) => {
        console.error('Erreur lors de la récupération de la liste de courses :', error);
        throw error; // À vous de décider comment gérer l'erreur
      })
    );
  }
  
  getArticlesFromUniqueBoutique(): Observable<Article[]> {
    const uniqueBoutiqueId = 1; // Remplacez par l'ID de votre seule boutique
    return this.httpClient.get<Article[]>(`${this.apiUrl}/boutiques/${uniqueBoutiqueId}/articles`);
  }

  getRecettes(): Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.apiUrl}/recettes/1`);
  }

}
