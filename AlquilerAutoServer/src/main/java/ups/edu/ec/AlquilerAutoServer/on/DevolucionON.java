package ups.edu.ec.AlquilerAutoServer.on;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.AlquilerAutoServer.dao.DevolucionDAO;
import ups.edu.ec.AlquilerAutoServer.dao.FacturaDAO;
import ups.edu.ec.AlquilerAutoServer.dao.PedidoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
@Stateless
public class DevolucionON implements DevolucionONLocal {
	@Inject
	private DevolucionDAO devolucionDAO;
	
	@Inject
	private FacturaDAO facturaDAO;
	
	@Inject
	private PedidoDAO pedidoDAO;
	
	public void insertarDevolucion(Devolucion devolucion) throws Exception {
		devolucionDAO.insert(devolucion);
	}
	
	
	public void actualizarDevolucion(Devolucion devolucion) throws Exception {
		devolucionDAO.update(devolucion);
	}
	
	public Devolucion buscarDevolucion(int id) throws Exception {
		return devolucionDAO.read(id);
	}
	
	public void eliminarDevolucion(int id) throws Exception {
		devolucionDAO.delete(id);
	}
	public List<Devolucion> getDevolucions(){
		try {
			return devolucionDAO.getDevoluciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Devolucion> getAntecedentes(Persona cedula) {
		List<Devolucion> devoluciones= new ArrayList<Devolucion>();
		/*
		for(Devolucion elemento: devoluciones) {
			Factura f= new Factura();
			pedidoCabecera p = new pedidoCabecera();
			f=elemento.getFactura();
			p=f.getPedido();
			
		}
		*/
		
		List<pedidoCabecera> pedidos=pedidoDAO.getListaNombre(cedula);
		System.out.println("Lista pedidos:"+pedidos.size());
		
		for(pedidoCabecera elemento:pedidos) {
			System.out.println(elemento.getId());
			Factura f= new Factura();
			f=facturaDAO.getPedido(elemento);
			List<Devolucion> listado= devolucionDAO.getAntecedentes(f);
			Devolucion d= new Devolucion();
			if(listado.size() == 1) {
				
			//Devolucion d= new Devolucion();
			//pedidoCabecera cab= new pedidoCabecera();
				listado=devolucionDAO.getAntecedentes(f);
				d=listado.get(0);
				devoluciones.add(d);
			}else {
				for(Devolucion ele: listado) {
					devoluciones.add(ele);
				}
			}
			
		}
		return devoluciones;
	}
	
}
