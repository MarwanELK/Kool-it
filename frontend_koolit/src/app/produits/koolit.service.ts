import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  private apiUrl = "http://localhost:8080";
  backendUrl = 'http://localhost:8080';

  readonly ENDPOINT_RECETTES = "/recettes";
  readonly ENDPOINT_LISTE_COURSE = "/liste-course";

  constructor(private http: HttpClient) {}

  ajouterIngredient(utilisateurId: number, nouvelIngredient: any): Observable<any> {
    const url = `${this.apiUrl}/liste-course/${utilisateurId}`;
    return this.http.post<any>(url, nouvelIngredient).pipe(
      tap(response => console.log('Réponse du serveur (ajout d\'ingrédients) :', response)),
      catchError((error: any) => {
        console.error('Erreur lors de l\'ajout d\'ingrédients :', error);
        return throwError(error);
      })
    );
  }
  getRecettes(): Observable<any[]> {
    const url = `${this.backendUrl}/recettes`;
    return this.http.get<any[]>(url);
  }

  ajouterIngredientAListeCourse(utilisateurId: number, data: any): Observable<any> {
    const url = `${this.backendUrl}/ajouterIngredientAListeCourse/${utilisateurId}`;
    return this.http.post<any>(url, data);
  }

  getListeDeCourses(utilisateurId: number): Observable<any[]> {
    const url = `${this.backendUrl}/liste-course/${utilisateurId}`;
    return this.http.get<any[]>(url).pipe(
      catchError(error => {
        console.error('Erreur lors de la récupération de la liste de courses :', error);
        throw error;
      })
    );
  }
  
  
}
