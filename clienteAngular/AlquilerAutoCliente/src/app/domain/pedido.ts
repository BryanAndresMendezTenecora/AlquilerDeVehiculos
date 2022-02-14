import { Detalle } from "./detalle";
import { Persona } from "./persona";

export class Pedido{
    
    id:number;
    fecha:string;
    fechaentrega:String;
    persona:Persona=new Persona();
    detalles:Detalle[];

}