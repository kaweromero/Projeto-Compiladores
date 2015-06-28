public class Main {
	public static void main(String[] args) {
		System.out.println("Digite uma expressao aritmetica");
		System.out.print("e um ponto-e-virgula para finalizar: ");
		Analisador analisador = new Analisador(System.in);
		try {
			SimpleNode n = analisador.processa();
			n.dump("");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}