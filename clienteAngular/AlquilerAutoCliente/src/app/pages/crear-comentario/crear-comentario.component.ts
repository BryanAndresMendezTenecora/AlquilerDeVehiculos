import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Comentario } from '../../domain/comentario';
import { ComentarioService } from '../../services/comentario.service';

@Component({
  selector: 'app-crear-comentario',
  templateUrl: './crear-comentario.component.html',
  styleUrls: ['./crear-comentario.component.scss']
})
export class CrearComentarioComponent implements OnInit {
  id:any;
  cedula:any;
  comentario:Comentario=new Comentario();
  constructor(private activatedRoute:ActivatedRoute,private ComentarioService:ComentarioService) { 
    this.id=this.activatedRoute.snapshot.params['id'];
    console.log("llega===>",this.id)
    this.comentario.vehiculo.id=this.id
    console.log("pasa valor a id===>",this.comentario.vehiculo.id)
  }

  ngOnInit(): void {
  }

  guardar(){
    console.log(this.comentario)
    this.ComentarioService.guardarComentario(this.comentario).subscribe(data=>{
      console.log("Poni=>",data);
    });
    
  }

}
