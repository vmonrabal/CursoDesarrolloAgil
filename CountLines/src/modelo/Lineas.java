package modelo;

import java.util.ArrayList;

public class Lineas {

	private ArrayList<Linea> lineas;
	
	public Lineas(String file){
		lineas = new ArrayList<Linea>();
		if(!"".equals(file)){
			String[] str = file.split("\n");
			for(int i = 0; i < str.length ; i++){
				lineas.add(new Linea(str[i]));
			}
		}
	}
	
	public int countCodeLines(){
		int nlines = 0;
		for(Linea linea : lineas){
			if(linea.isCodeLine())
				nlines++;
		}
		return nlines;
	}
}
