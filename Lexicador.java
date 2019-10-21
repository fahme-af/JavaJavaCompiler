import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;


public class Lexicador {
	private StringBuilder entrada = new StringBuilder();
	private boolean chavoso = false;
	private tokens osToken;
	private String lexlutor;
	private String erro = "";
	private Set<Character> branco = new HashSet<Character>();
	
	public Lexicador(String filePath) {
		try (Stream<String> st = Files.lines(Paths.get(filePath))){
			st.forEach(entrada::append);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			chavoso = true;
			erro = "Arquivo nao encontrado" + filePath;
			return;
		}
		branco.add('\r');
		branco.add('\n');
		branco.add((char) 8);
		branco.add((char) 9);
		branco.add((char) 11);
		branco.add((char) 12);
		branco.add((char) 32);
		tocaObaile();
	}
	
	public void tocaObaile() {
		if (chavoso) {
			return;
     	}
		if (entrada.length() == 0) {
			chavoso = true;
			return;
		}
		ignorarEspBranco();
		if (encontraOProx()) {
			return;
		}
		chavoso = true;
		if(entrada.length() > 0) {
			erro = "Simbolo Inexperado :" + entrada.charAt(0);	
		}
	}
	
	private boolean encontraOProx() {
		for(tokens token : tokens.values()) {
			int fim = token.fim(entrada.toString());
			
			if (fim != -1) {
				osToken = token;
				lexlutor = entrada.substring(0,fim);
				entrada.delete(0, fim);
				return true;
			}
		}
		
		return false;
	}
	
	public void ignorarEspBranco() {
		int del = 0;
		
		while (branco.contains(entrada.charAt(del))) {
			del++;
		}
		
		if(del>0) {
			entrada.delete(0, del);
		}
		
	}
	
	public String errorMessage() {
		return erro;
	}
	
	public tokens oTokenAi() {
		return osToken;
	}
	
	public String oLexlutorAi() {
		return lexlutor;
	}
	
	public boolean taChavoso() {
		return chavoso;
	}
	
	public boolean TAOK() {
		return errorMessage().isEmpty();
	}
}
