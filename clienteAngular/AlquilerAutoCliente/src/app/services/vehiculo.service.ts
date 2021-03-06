import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Vehiculo } from '../domain/Vehiculo';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {

  constructor(private http:HttpClient) { }

  guardarVehiculo(vehiculo : Vehiculo):Observable<any>{
    const url ="http://localhost:8080/AlquilerAutoServer/ws/vehiculos";
    return this.http.put<any>(url,vehiculo)
  }

  getVehiculo():Observable<any>{
    const url = "http://localhost:8080/AlquilerAutoServer/ws/vehiculos";
    return this.http.get<any>(url)

  }
  buscarvehiculo(nombre:string):Observable<any>{
    console.log("service->",nombre)
    const url = "http://localhost:8080/AlquilerAutoServer/ws/vehiculos/buscarC";
    return this.http.post<any>(url,nombre)

  }
}
