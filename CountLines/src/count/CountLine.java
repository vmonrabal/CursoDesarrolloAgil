package count;

import modelo.Lineas;

public class CountLine {
	
	public int returnLines(String input){
		Lineas lineas = new Lineas(input);
		return lineas.countCodeLines();
	}
	
}
