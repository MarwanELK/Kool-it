import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  private apiUrl = "http://localhost:8080";
  backendUrl = 'http://localhost:8080';

  readonly ENDPOINT_RECETTES = "/recettes";
  readonly ENDPOINT_LISTE_COURSE = "/liste-course";

  constructor(private http: HttpClient) {}


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
    return this.http.get<any[]>(url);
  }
  ajouterIngredient(utilisateurId: number, nouvelIngredient: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/liste-course/${utilisateurId}`, nouvelIngredient);
  }
  
}