import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { tap } from 'rxjs/operators';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  private apiUrl = "http://localhost:8080";

  readonly ENDPOINT_RECETTES = "/recettes";
  readonly ENDPOINT_MAGASINS = "/magasins";
  readonly ENDPOINT_VILLES = "/villes";
  constructor(private httpClient: HttpClient) { }

  getListeDeCourses(utilisateurId: number): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.apiUrl}/liste-course/${utilisateurId}`).pipe(
      map((data: any[]) => {
        return data.map(ingredient => ({
          nom: ingredient.nom,
          type: ingredient.type,
          quantite: ingredient.quantite,
          ingredientsList: JSON.parse(ingredient.ingredients)
        }));
      }),
      catchError((error: any) => {
        console.error('Erreur lors de la récupération de la liste de courses :', error);
        throw error;
      })
    );
  }

  getRecettes(): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.apiUrl}${this.ENDPOINT_RECETTES}`).pipe(
      catchError((error: any) => {
        console.error('Erreur lors de la récupération des recettes :', error);
        throw error;
      })
    );
  }

  getMagasins(): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.apiUrl}${this.ENDPOINT_MAGASINS}`).pipe(
      tap(data => console.log('Données brutes des magasins :', data)),
      catchError((error: any) => {
        console.error('Erreur lors de la récupération des magasins :', error);
        throw error;
      })
    );
  }
  // koolit.service.ts

  rechercherMagasinParNom(nomMagasin: string): Observable<any> {
    console.log('Valeur de nomMagasin :', nomMagasin);
    const params = new HttpParams().set('nomMagasin', nomMagasin);
    return this.httpClient.get<any[]>(`${this.apiUrl}${this.ENDPOINT_MAGASINS}/rechercher`, { params }).pipe(
      catchError((error: any) => {
        console.error('Erreur lors de la recherche de magasin par ville :', error);
        throw error;
      })
    );
  }


  ajouterTypeAliment(nomMagasin: string, typeAliment: string): Observable<any> {
    const url = `${this.apiUrl}/magasins/ajouterTypeAliment/${nomMagasin}`;
    return this.httpClient.post(url, typeAliment);
  }

  getCoccinelle(): Observable<any> {
    return this.httpClient.get<any>(`${this.apiUrl}${this.ENDPOINT_MAGASINS}/coccinelle`);
  }

  getMagasinsParVille(ville:string): Observable<any> {
    const params = new HttpParams().set('ville', ville);
    return this.httpClient.get<any[]>(`${this.apiUrl}${this.ENDPOINT_MAGASINS}/ville`, { params }).pipe(
      catchError((error: any) => {
        console.error('Erreur lors de la recherche de magasin par ville :', error);
        throw error;
      })
    );
  }

  getVilleParNom(nomVille:string): Observable<any> {
    const params = new HttpParams().set('nomVille', nomVille);
    return this.httpClient.get<any[]>(`${this.apiUrl}${this.ENDPOINT_VILLES}/rechercherNom`, { params }).pipe(
      catchError((error: any) => {
        console.error('Erreur lors de la recherche de ville par nom :', error);
        throw error;
      })
    );
  }

  getVilleParCoords(lat:number,lng:number): Observable<any> {
    const params = new HttpParams()
        .set('lat', lat)
        .set('lng', lng);

    return this.httpClient.get<any[]>(`${this.apiUrl}${this.ENDPOINT_VILLES}/rechercherCoords`, { params }).pipe(
        catchError((error: any) => {
            console.error('Erreur lors de la recherche de ville par ses coords :', error);
            throw error;
        })
    );
    
  }
}
