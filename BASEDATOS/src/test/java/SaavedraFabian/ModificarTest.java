package SaavedraFabian;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SaavedraFabian.Modelo.BaseDeDatos;
import SaavedraFabian.Modelo.Dato;

public class ModificarTest {

	private BaseDeDatos base;
	@Before
	public void setUp() throws Exception {
		this.base=new BaseDeDatos();
		base.agregar(new Dato("A1","Es A1"));
		base.agregar(new Dato("A2","Es A2"));
		base.agregar(new Dato("A3","Es A3"));
	}

	@Test
	public void cuandoModificoEntoncesTrue() {
		boolean resultado= this.base.modificar(new Dato("A1","Es pero Modificado A1"));
		assertTrue("Cuando modifico A1 en true y es"+ resultado, resultado);
	}

	@Test
	public void cuandoModificoUnoQueNoExisteEntoncesFalse() {
		boolean resultado= this.base.modificar(new Dato("A4","Es pero Modificado A4"));
		assertFalse("Cuando modifico A4 en false y es"+ resultado, resultado);
	}
	
	@Test
	public void cuandoModificoUnoQueEsNullEntoncesFalse() {
		boolean resultado= this.base.modificar(new Dato(null,"Es pero Modificado A4"));
		assertFalse("Cuando modifico A4 en false y es"+ resultado, resultado);
	}
}
