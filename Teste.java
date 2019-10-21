
public class Teste {
	public static void main(String[] args) {
		Lexicador lexlutor = new Lexicador("C:/Facul/teste.txt");
		if(lexlutor.TAOK()) {
			System.out.println("Ta rodando, taok!");
		}else {
			System.out.println(lexlutor.errorMessage());
		}
		System.out.println("---------------------");
		System.out.println("A analise Lexica ai");
		System.out.println("---------------------");
		while (!lexlutor.taChavoso()) {
			System.out.printf("%s : %-18s \n", lexlutor.oTokenAi(), lexlutor.oLexlutorAi());
			lexlutor.tocaObaile();
		}
	}
}
