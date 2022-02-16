import { Detalle } from "./detalle";
import { Persona } from "./persona";

export class Pedido{
    
    id:number;
    fecha:string;
    fechaentrega:String;
    estado:string;
    persona:Persona=new Persona();
    detalles:Detalle[];

}