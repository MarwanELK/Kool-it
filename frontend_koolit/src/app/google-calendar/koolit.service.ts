// koolit.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KoolitService {

  private apiUrl = "http://localhost:4200";

  constructor(private httpClient: HttpClient) { }

  insertEvent(accessToken: string, personId: string): Observable<any> {
    const url = '${this.apiUrl}/insert-event';
    const body = { code: accessToken, personId: personId };
    return this.httpClient.post(url, body, { responseType: 'text' });
  }
}
