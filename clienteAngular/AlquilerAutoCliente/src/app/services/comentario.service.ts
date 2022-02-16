import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comentario } from '../domain/comentario';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ComentarioService {
comentarios:Comentario;

  constructor(private http:HttpClient) { }


  guardarComentario(comentario : Comentario):Observable<any>{
    const url = environment.WS_PATH +"/comentario";
    return this.http.put<any>(url,comentario)
  }

  getComentario():Observable<any>{
    const url = environment.WS_PATH +"/comentario";
    return this.http.get<any>(url)

  }



  getAutoCoemntario(n:number):Observable<any>{
    const url = environment.WS_PATH +"/comentario/buscarComentario";
    return this.http.post<any>(url,n)

  }
}
