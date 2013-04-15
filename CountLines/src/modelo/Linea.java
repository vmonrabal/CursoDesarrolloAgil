package modelo;

public class Linea {
	
	private String linea;
	
	private final String SIMPLE_COMMENT = "//";
	private final String INIT_BLOCK_COMMENT = "/*";
	private final String BLOCK_COMMENT = "*";
	private final String END_BLOCK_COMMENT = "*/";
	
	public Linea(String linea){
		this.linea = linea;
	}
	
	public boolean isCodeLine(){
		
		if(linea.startsWith(SIMPLE_COMMENT) || linea.startsWith(INIT_BLOCK_COMMENT)
			|| linea.startsWith(BLOCK_COMMENT) || linea.startsWith(END_BLOCK_COMMENT))
			return false;	
		
		return true;
	}
}
