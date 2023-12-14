import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  private apiUrl = "http://localhost:8080";

  readonly ENDPOINT_RECETTES = "/recettes";
  readonly ENDPOINT_LISTE_COURSE = "/liste-course";

  constructor(private httpClient: HttpClient) {}

  getListeDeCourses(utilisateurId: number): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}${this.ENDPOINT_LISTE_COURSE}/${utilisateurId}`);
  }

  ajouterIngredientAListeCourse(utilisateurId: number, nouvelIngredient: any): Observable<any> {
    return this.httpClient.post(`${this.apiUrl}${this.ENDPOINT_LISTE_COURSE}/${utilisateurId}`, nouvelIngredient);
  }
  ajouterIngredient(utilisateurId: number, nouvelIngredient: any): Observable<any> {
    return this.httpClient.post(`${this.apiUrl}/liste-course/${utilisateurId}`, nouvelIngredient);
  }
  supprimerIngredient(ingredientId: number): Observable<any> {
    return this.httpClient.delete(`${this.apiUrl}${this.ENDPOINT_LISTE_COURSE}/${ingredientId}`);
  }
  
}
