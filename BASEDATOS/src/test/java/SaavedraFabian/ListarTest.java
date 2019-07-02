package SaavedraFabian;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SaavedraFabian.Modelo.BaseDeDatos;
import SaavedraFabian.Modelo.Dato;

public class ListarTest {

	private BaseDeDatos base;
	private BaseDeDatos baseVacia;
	@Before
	public void setUp() throws Exception {
		this.baseVacia=new BaseDeDatos();
		this.base=new BaseDeDatos();
		base.agregar(new Dato("A1","Es A1"));
		base.agregar(new Dato("A2","Es A2"));
		base.agregar(new Dato("A3","Es A3"));
	}

	//cuandoSituaciónEntoncesResultadoEsperado(
	@Test
	public void cuandoListamosTodoEntoncesRetorno3() {
		int largo=this.base.listar().size();
		assertTrue("Si listamos el largo es 3 y es"+largo,largo==3);
	}
	
	@Test
	public void cuandoListoListaVaciaEntoncesTrue() {
		int largo=this.baseVacia.listar().size();
		assertTrue("Si listamos el largo es 0 y es"+largo,largo==0);
	}

	
}
