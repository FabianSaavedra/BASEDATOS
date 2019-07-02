package SaavedraFabian.Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class BaseDeDatos {
	/***************ATRIBUTOS***********************/  
	private ArrayList<Dato> base;
	/***************CONSTRUCTORES***********************/ 
	public BaseDeDatos() {   this.base = new ArrayList<Dato>();  }  
	/***************MÉTODOS CRUD***********************/ 
	public ArrayList<Dato> listar() {   
		return this.base; 
		} 
	
	public boolean agregar(Dato dato) { 
		if(dato == null || dato.getId() == null || dato.getId().length()<=1) {  
			return false;
			}   
		return this.agregarOrdenado(dato); 
		} 
	
	private boolean agregarOrdenado(Dato dato) {  
		if(this.base.size() == 0) {    
			return this.base.add(dato);   
			}   for(int i=0; i<this.base.size(); i++) {
			int comparacion = dato.getId().compareToIgnoreCase(this.base.get(i).getId()); 
			if(comparacion == 0) {     return false;    }    
			if(comparacion < 0) {  
				this.base.add(i, dato);     
				return true;    } 
			}   return this.base.add(dato); 
		}  
	
	public boolean eliminar(String id) {
		Iterator<Dato> ite = this.base.iterator();   
		while(ite.hasNext()) {   
			if(ite.next().getId().equalsIgnoreCase(id)) { 
				ite.remove();  
				return true;   
				} 
			}   return false; 
			}  
	
	public boolean modificar(Dato dato) {  
		for(int i=0; i<this.base.size(); i++) { 
			if(this.base.get(i).getId().equals(dato.getId())) {  
				this.base.get(i).setData(dato.getData());   
				return true;    } 
			}   return false;  
			} 
	
	
}
