import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { Persona } from 'src/app/domain/persona';
import { ResponseI } from 'src/app/modelos/response.interface';
import { ServicepersonaService } from 'src/app/services/servicepersona.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
 personas:any;
 email:string;
 password:string;
 
 
  constructor(private personasService:ServicepersonaService, private router:Router ) { }
  errorStatus:boolean =false;
  errorMsj:any="";
  ngOnInit(): void {
    this.personas=this.personasService.getPersonasall();
    this.checkLocalStorage()
  }

  checkLocalStorage(){
    if(localStorage.getItem('token')){
      this.router.navigate(['listarVehiculo'])
    }

  }

  

    onLogin(email:string,password:string){
      //https://www.youtube.com/watch?v=D7z1Hdz4sGc
      this.personasService.loginByEmail(email,password).subscribe(data=>{
        console.log(data);
        let dataResponse:ResponseI=data;
        if(dataResponse.status=="oK"){
          localStorage.setItem("token",dataResponse.result.token);
          console.log("ingresooooo weeee",dataResponse.result.token)
          this.router.navigate(['listarVehiculo'])

        }else{
          this.errorStatus=true;
          //this.errorMsj=dataResponse.result.errorMsj;
          this.errorMsj="Usuario o contrasena incorrectos"
        }
      });
    }
  
     

 
}
