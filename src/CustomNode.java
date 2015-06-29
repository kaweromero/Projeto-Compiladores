

public class CustomNode extends SimpleNode {
	private TIPO tipo;	
	
	public CustomNode(Analisador p, int i) {
		super(p, i);
	}

	public CustomNode(int i) {
		super(i);
	}

	public TIPO getTipo() {
		return tipo;
	}

	public void setTipo(TIPO tipo) {
		this.tipo = tipo;
	}
	
	public String getValue() {
		if(this.value instanceof Token)
			return ((Token)this.value).image;
		return null;
	}
		
	public enum TIPO {
		INT, FLOAT, NULL, BOOLEAN
	}

}