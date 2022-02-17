import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../domain/persona';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ResponseI } from '../modelos/response.interface';

@Injectable({
  providedIn: 'root'
})
export class ServicepersonaService {

  constructor(private http:HttpClient) { }
  guardarPersonas(persona : Persona):Observable<any>{
    const url = "http://localhost:8080/AlquilerAutoServer/ws/personas";
    return this.http.put<any>(url,persona)
  }

  getPersonas():Observable<any>{
    const url = "http://localhost:8080/AlquilerAutoServer/ws/personas";
    return this.http.get<any>(url)

  }

  getPersonasall():Observable<Persona>{
    const url = "http://localhost:8080/AlquilerAutoServer/ws/personas";
    return this.http.get<Persona>(url)

  }

  loginByEmail(email:string,password:string):Observable<ResponseI>{
      console.log("serves->",email)
    //const url = environment.WS_PATH +"/personas/login";
    const url = "http://localhost:8080/AlquilerAutoServer/ws/personas/loginP?email="+email+"&password="+password;
    return this.http.get<ResponseI>(url);
  }
}
