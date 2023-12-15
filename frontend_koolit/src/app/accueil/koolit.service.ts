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
  

  constructor(private httpClient: HttpClient) { }

 

  
  
}
