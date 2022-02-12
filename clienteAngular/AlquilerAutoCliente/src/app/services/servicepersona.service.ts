import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../domain/persona';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServicepersonaService {

  constructor(private http:HttpClient) { }
  guardarPersonas(persona : Persona):Observable<any>{
    const url = environment.WS_PATH +"/personas";
    return this.http.put<any>(url,persona)
  }

  getPersonas():Observable<any>{
    const url = environment.WS_PATH +"/personas";
    return this.http.get<any>(url)

  }
}
