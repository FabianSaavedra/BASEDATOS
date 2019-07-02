package SaavedraFabian;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SaavedraFabian.Modelo.BaseDeDatos;
import SaavedraFabian.Modelo.Dato;

public class AgregarTest {

	private BaseDeDatos base;
	@Before
	public void setUp() throws Exception {
		this.base = new BaseDeDatos();
		base.agregar(new Dato("A1","Es A1"));
		base.agregar(new Dato("A2","Es A2"));
		base.agregar(new Dato("A3","Es A3"));
	}

	//cuandoSituaciónEntoncesResultadoEsperado()
	@Test
	public void cuendoAgregarEntoncesEsTrue() {
		boolean resultado=this.base.agregar(new Dato("A4","Soy A4"));
		boolean resultado2=this.base.agregar(new Dato("A5","Soy A5"));
		System.out.println(base.listar());
		assertTrue("Cuando agredo es true y entonces es "+resultado,resultado && resultado2);
	}
	
	@Test
	public void cuendoAgregarYOrdenaEntoncesEsTrue() {
		boolean resultado=this.base.agregar(new Dato("B4","Soy B4"));
		boolean resultado2=this.base.agregar(new Dato("A5","Soy A5"));
		Dato ultimo=this.base.listar().get(4);
		System.out.println("SO Y EL ULTIMO "+ ultimo);
		boolean ordeno=ultimo.getId().equalsIgnoreCase("B4");
		System.out.println(base.listar());
		assertTrue("Cuando agredo ordenadamente es true y entonces es "+resultado,resultado && resultado2 && ordeno);
	}
	
	@Test
	public void cuandoAgregoUnNullEsFalse() {
		boolean resultado=this.base.agregar(null);
		System.out.println("SOY "+resultado);
		assertFalse("Cuando agredo un null es false y entonces es "+resultado,resultado);
	}
	
	@Test
	public void cuandoAgregoIdMenora1EntoncesEsFalse() {
		boolean resultado=this.base.agregar(new Dato("A","Soy A4"));
		System.out.println("SOY "+resultado);
		assertFalse("Cuando agredo un id.length<=1 es false y entonces es "+resultado,resultado);
	}
	
	@Test
	public void cuandoAgregoIdNullEntoncesEsFalse() {
		boolean resultado=this.base.agregar(new Dato(null,"Soy A1"));
		System.out.println("SOY "+resultado);
		assertFalse("Cuando agredo un id==Null es false y entonces es "+resultado,resultado);
	}

}
