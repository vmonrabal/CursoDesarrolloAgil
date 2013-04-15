package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import count.CountLine;

public class CountLinesTest {
	private CountLine line;
	private String cadena;
	
	@Before
	public void before(){
		line = new CountLine();
	}
	
	@Test
	public void count_cadena_vacia() {
				
		int actual = line.returnLines("");
		
		assertEquals(0, actual);
	}
	
	@Test
	public void count_una_linea() {
		cadena = "Hola";
		int actual = line.returnLines(cadena);
		
		assertEquals(1, actual);
	}
	
	@Test
	public void count_dos_lineas() {
		cadena = "Hola\nMundo";
		int actual = line.returnLines(cadena);
		
		assertEquals(2, actual);
	}
	
	@Test
	public void count_tres_lineas() {
		cadena = "Hola//Mundo";
		int actual = line.returnLines(cadena);
		
		assertEquals(1, actual);
	}
	
	@Test
	public void count_con_comentarios_lineas() {
		cadena ="//Comentario Hola\n" +
				"Mundo\n" +
				"Todos\n" +
				"//esto es una cadena";
		int actual = line.returnLines(cadena);
		
		assertEquals(2, actual);
	}
	
	@Test
	public void count_con_comentarios_varias_lineas() {
		cadena ="/*\n" +
				"*Comentario Hola\n" +
				"*/\n" +
				"Mundo\n" +
				"Todos\n";
		int actual = line.returnLines(cadena);
		
		assertEquals(2, actual);
	}
	
	@Test
	public void count_casouso_lineas() {
		cadena ="// This file contains 3 lines of code\n" +
				"public interface Dave {\n" +
				"/**\n" +
				"* count the number of lines in a file\n" +
				"*/\n" +
				"int countLines(File inFile); // not the real signature!\n" +
				"}\n";
		int actual = line.returnLines(cadena);
		
		assertEquals(3, actual);
	}

}
