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
  readonly ENDPOINT_LISTE_COURSE = "/liste-course";
  constructor(private httpClient: HttpClient) { }

  getListeDeCourses(utilisateurId: number): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}${this.ENDPOINT_LISTE_COURSE}/${utilisateurId}`);
  }

  supprimerIngredient(ingredientId: number): Observable<any> {
    return this.httpClient.delete(`${this.apiUrl}${this.ENDPOINT_LISTE_COURSE}/${ingredientId}`);
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

  rechercherMagasinParNom(nomMagasin: string, ville: string): Observable<any> {
    console.log('Valeur de nomMagasin :', nomMagasin);
    const params = new HttpParams().set('nomMagasin', nomMagasin).set('ville', ville);
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
  ajouterIngredientAListeCourse(utilisateurId: number, data: any): Observable<any> {
    const url = `${this.apiUrl}/ajouterIngredientAListeCourse/${utilisateurId}`;
    return this.httpClient.post<any>(url, data);
  }

  ajouterIngredient(utilisateurId: number, nouvelIngredient: any): Observable<any> {
    return this.httpClient.post(`${this.apiUrl}/liste-courseAchete/${utilisateurId}`, nouvelIngredient);
  }
}