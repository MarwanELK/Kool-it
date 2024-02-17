import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VetServiceService {
  private baseUrl = 'http://localhost:8080'; // Mettez votre URL backend ici

  constructor(private http: HttpClient) { }

  searchVets(city: string, latitude: number, longitude: number, radius: number): Observable<any> {
    const apiUrl = `${this.baseUrl}/api/veterinaires`;
    const params = {
      city: encodeURIComponent(city),
      latitude: latitude.toString(),
      longitude: longitude.toString(),
      radius: radius.toString()
    };

    return this.http.get(apiUrl, { params });
  }
}
