import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'



@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  readonly API_URL = "http://localhost:8080"

  readonly ENDPOINT_RECETTES ="/recettes"
  readonly ENDPOINT_LISTEDECOURSES="/liste-de-courses"
  constructor(private httpClient : HttpClient) { 

  }

  getRecettes(){
    return this.httpClient.get(this.API_URL+this.ENDPOINT_RECETTES)
  }
  getListeDeCourses(){
    return this.httpClient.get(this.API_URL+this.ENDPOINT_LISTEDECOURSES)
  }
  
}
