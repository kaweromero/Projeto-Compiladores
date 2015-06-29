


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Controlador {
	private Map<String, Simbolo> simbolos = new HashMap<String, Simbolo>();
	private List<Erro> errosSemanticos = new ArrayList<Erro>();

	public Controlador() {

	}

	public void declaracao(CustomNode.TIPO tipo, Token t) {
		this.declaracao(tipo, t, false);
	}

	public void declaracao(CustomNode.TIPO tipo, Token t, boolean funcao) {
		this.declaracao(tipo, t, funcao, false);
	}

	public void declaracao(CustomNode.TIPO tipo, Token t, boolean funcao,
			boolean usado) {
		// System.out.println("Declarando o tipo "+tipo+" para o id "+t);
		Simbolo s = simbolos.get(t.image);
		if (s == null) {
			simbolos.put(t.image, criarSimbolo(tipo, t, funcao, usado));
		} else {
			addErro(t.beginLine, "Variável " + t.image + " já declarada");
		}
	}

	private Simbolo criarSimbolo(CustomNode.TIPO tipo, Token t, boolean funcao,
			boolean usado) {
		return new Simbolo(tipo, t, funcao, usado);
	}

	public void addErro(int linha, String msg) {
		Erro erro = new Erro();
		erro.linha = linha;
		erro.msg = msg;
		errosSemanticos.add(erro);
	}

	public TIPO getTipo(Token t) {
		Simbolo s = simbolos.get(t.image);
		if (s == null) {
			addErro(t.beginLine, "Variável " + t.image + " não declarada");
			// adota o inteiro ja que nao se sabe o tipo
			s = new Simbolo(TIPO.INT, t, true, false);
			simbolos.put(t.image, s);
		} else {
			s.usado = true;
		}
		return s.tipo;
	}

	public void imprimeErrosSemanticos() {
		// Verifica se alguma variavel n foi usada
		for (Simbolo simbolo : simbolos.values())
			if (!simbolo.usado) {
				Warning w = new Warning();
				w.linha = simbolo.token.beginLine;
				w.msg = "Variável " + simbolo.token.image
						+ " declarada mas não usada";
				errosSemanticos.add(w);
			}

		Collections.sort(errosSemanticos);

		for (Erro erro : errosSemanticos) {
			System.out.println("  " + erro);
		}
	}

	// ===================CLASSES INTERNAS=====================
	private class Erro implements Comparable<Erro> {
		int linha;
		String msg;

		@Override
		public int compareTo(Erro arg0) {
			return new Integer(linha).compareTo(arg0.linha);
		}

		@Override
		public String toString() {
			return "Erro na linha " + linha + ": " + msg;
		}
	}

	private class Warning extends Erro {
		@Override
		public String toString() {
			return "Warning na linha " + linha + ": " + msg;
		}
	}

	private class Simbolo {
		TIPO tipo;
		Token token;
		boolean usado;
		@SuppressWarnings("unused")
		boolean funcao;

		private Simbolo(TIPO tipo, Token token, boolean usado, boolean funcao) {
			super();
			this.tipo = tipo;
			this.token = token;
			this.usado = usado;
			this.funcao = funcao;
		}

	}

}