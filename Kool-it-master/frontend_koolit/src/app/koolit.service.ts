import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';


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
        throw error; 
      })
    );
  }
  
  

  getRecettes(): Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.apiUrl}/recettes/1`);
  }

  exportCalendar(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/export-calendar`, { responseType: 'text' });
  }

  oauth2Callback(code: string): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/oauth2callback?code=${code}`);
  }

  insertEvent(accessToken: string, personId: string) {
    const url = 'http://localhost:8080/insert-event'; 
    const body = { code: accessToken, personId: personId };
    return this.httpClient.post(url, body, { responseType: 'text' });
  }

}
