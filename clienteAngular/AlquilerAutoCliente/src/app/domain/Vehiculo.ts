import { Categoria } from './Categoria';
export class Vehiculo{
    
    id:number;
    estado:string;
    modelo:string;
    marca:string;
    stock:number;
    precio:number;
    categoria:Categoria=new Categoria();

}