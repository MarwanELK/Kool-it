// recette.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RecetteService {
  private backendUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) {}

  getRecettes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.backendUrl}/recettes`);
  }

  noterRecette(recetteId: number, note: number): Observable<any> {
    note = Math.min(Math.max(note, 0), 10);

    const url = `${this.backendUrl}/recettes/${recetteId}/noter?note=${note}`;
    return this.http.post<any>(url, {});
  }
}
