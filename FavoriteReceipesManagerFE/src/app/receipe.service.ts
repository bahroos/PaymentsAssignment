import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReceipeService {



  private baseUrl = 'https://dhirajappservice01.azurewebsites.net/receipes';

  constructor(private http: HttpClient) { }

  getReceipe(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`,
      { headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  createReceipe(receipe: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}`, receipe,
      { headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  updateReceipe(id: number, value: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, value,
      { headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  deleteReceipe(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  getReceipesList(): Observable<any> {
    console.log("Calling get receipe list");
    return this.http.get(`${this.baseUrl}`,{ headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }
}
