package ups.edu.ec.AlquilerAutoServer.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaON;

@Named
@RequestScoped
public class CategoriaBean {
	
	private CategoriaON categoriaON;
	private Categoria categoria;
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String guardar() {

		//System.out.println("Guardando " + this.categoria.getMarca());

		/*
		 * Persona p= new Persona(); p.setCedula(this.cedula); p.setNombre(this.nombre);
		 * p.setDireccion(this.direccion);
		 */
		try {
			categoriaON.insertarCategoria(this.categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return "listado-personas?faces-redirect=true";
		return null;
	}
	
}
