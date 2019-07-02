package SaavedraFabian;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SaavedraFabian.Modelo.BaseDeDatos;
import SaavedraFabian.Modelo.Dato;

public class EliminarTest {

	private BaseDeDatos base;
	@Before
	public void setUp() throws Exception {
		this.base= new BaseDeDatos();
		base.agregar(new Dato("A1","Es A1"));
		base.agregar(new Dato("A2","Es A2"));
		base.agregar(new Dato("A3","Es A3"));
		
	}

	// cuandoSituaciónEntoncesResultadoEsperado(
	@Test
	public void cuandoEliminoPorIdAlPrimeroEntoncesTrue() {
		boolean resultado= this.base.eliminar("A1");
		assertTrue("Cuando elimino A1 es true y es "+resultado,resultado);			
	}
	
	@Test
	public void cuandoEliminoIdQueNoExisteEntoncesEsFalse() {
		boolean resultado= this.base.eliminar("Z1");
		assertFalse("Cuando elimino Z1 que no existe es falsee y es "+resultado,resultado);
	}
	@Test
	public void cuandoEliminoIndependienteDeIDMayusculaaEntoncesEstrue() {
		boolean resultado= this.base.eliminar("a1");
		assertTrue("Cuando elimino A1 es true y es "+resultado,resultado);	
	}

	@Test
	public void cuandoEliminoUltimoDatoEnLaListaEntoncesTrue() {
		boolean resultado= this.base.eliminar("A3");
		assertTrue("Cuando elimino A1 es true y es "+resultado,resultado);
	}
	
	@Test
	public void cuandoEliminoEntrePrimerYUltimoElementoEntoncesTrue() {
		boolean resultado= this.base.eliminar("A3");
		assertTrue("Cuando elimino A1 es true y es "+resultado,resultado);

	}
}
