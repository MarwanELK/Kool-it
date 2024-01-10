// boutique.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BoutiqueService {
  private baseUrl = 'http://localhost:8080';  // Remplacez cela par l'URL de votre backend

  constructor(private http: HttpClient) {}

  getArticlesByBoutique(boutiqueId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/boutiques/${boutiqueId}`);
  }
}
