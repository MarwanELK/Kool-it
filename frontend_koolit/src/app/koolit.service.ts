import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  private apiUrl = "http://localhost:8080/"

  readonly ENDPOINT_RECETTES ="/recettes"
  constructor(private httpClient : HttpClient) { 

  }

  getRecettes(): Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.apiUrl}/recettes/1`);
  }

}
