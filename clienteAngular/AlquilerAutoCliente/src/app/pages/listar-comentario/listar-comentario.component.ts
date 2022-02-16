import { Component, OnInit } from '@angular/core';
import { Comentario } from '../../domain/comentario';
import { ComentarioService } from '../../services/comentario.service';


@Component({
  selector: 'app-listar-comentario',
  templateUrl: './listar-comentario.component.html',
  styleUrls: ['./listar-comentario.component.scss']
})
export class ListarComentarioComponent implements OnInit {
  comentarios:any;
  constructor(private ComentarioService:ComentarioService) { }

  ngOnInit(): void {
    this.comentarios=this.ComentarioService.getComentario();
  }

}
