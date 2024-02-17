// wikingredients.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class WikingredientsService {
  private backendUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}
  getAllNomAliments(): Observable<string[]> {
    const url = `${this.backendUrl}/wikingredients/nom`; // Mettez à jour le chemin si nécessaire
    return this.http.get<string[]>(url);
  }

  getAllWikingredients(): Observable<any[]> {
    const url = `${this.backendUrl}/wikingredients`;
    return this.http.get<any[]>(url);
  }

  getAliment(): Observable<any[]> {
    return this.http.get<any[]>(`${this.backendUrl}/wikingredients`);
  }

  obtenirInfoNutritionnelle(wikingredientId: number): Observable<any> {
    const url = `${this.backendUrl}/wikingredients/${wikingredientId}/infoNutritionnelle`;
    return this.http.get<any>(url);
  }

  ajouterAliment(wikingredientData: any): Observable<any> {
    const url = `${this.backendUrl}/wikingredients`;
    return this.http.post<any>(url, wikingredientData);
  }

  noterAliment(wikingredientId: number, note: number): Observable<any> {
    note = Math.min(Math.max(note, 0), 10);

    const url = `${this.backendUrl}/wikingredients/${wikingredientId}/noter?note=${note}`;
    return this.http.post<any>(url, {});
  }
}
