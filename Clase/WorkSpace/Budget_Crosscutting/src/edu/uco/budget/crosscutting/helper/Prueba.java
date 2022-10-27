package edu.uco.budget.crosscutting.helper;

import java.util.ArrayList;
import java.util.List;
import static edu.uco.budget.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.budget.crosscutting.helper.StringHelper.isEmpty;


public class Prueba {
	
	public static void main(String[] args) {
		
		String cadena, cadena2, cadena3;
		
		cadena = "hola";
		cadena2 = "";
		cadena3 = "  ";
	
		List<String> cadenas = new ArrayList<>();
		cadenas.add(cadena);
		cadenas.add(cadena2);
		cadenas.add(cadena3);
		
		
		
		cadenas.forEach(c -> System.out.println("normal: " + c + " longitud " + c.length()));
		cadenas.forEach(c -> System.out.println("quitando vacios: " + applyTrim(c) + " longitud " + applyTrim(c).length()));
		cadenas.forEach(c -> System.out.println("es vacia?: " + isEmpty(c) + " longitud " + c.length() ));
		
		
		
		
		
		
	}
}
