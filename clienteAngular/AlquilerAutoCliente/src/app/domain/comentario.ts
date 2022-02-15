import { Persona } from './persona';
import { Vehiculo } from './Vehiculo';
export class Comentario{ 
    id:number;
    descripcion:string;
    calificacion:number;
    persona:Persona=new Persona();
    vehiculo:Vehiculo=new Vehiculo();

}