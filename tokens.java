import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum tokens {
	PLUS ("\\+"),
	MINUS ("-"),
	MUL ("\\*"),
	DIV ("/"),
	NOT ("~"),
	AND("&"),
	OR("\\|"),
	LESS("<"),
	LESSEQ("<="),
	GRT(">"),
	GRTEG(">="),
	IGUA("=="),
	ATTRIB("="),
	ABRIRP("\\("),
	FECHAP("\\)"),
	PONTIVIR(";"),
	STRINGO("\"[^\"]+\""),
	INTEIRO("\\d+"),
	REALO("(\\d*)\\,\\d+"),
	NOMEVAR("\\w+"),
	P_DEFIN("define"),
	P_ASS("as"),
	P_SE("if"),
	O_ABREOCHAVES("\\{"),
	O_FECHAROCHAVES("\\}"),
	O_DIFERENTAO("!="),
	P_ENTAO("then"),
	P_SENAO("else"),
	P_FIMSE("endif"),
	T_PUBLICO("public"),
	T_PRIVADO("private"),
	T_VAZIO("void"),
	T_INTEIRO("int"),
	T_ESTATICO("static"),
	T_MAINHA("main");
	
	private final Pattern padrao;
	tokens(String x){
		padrao = Pattern.compile("^" + x);
	}
	int fim(String f) {
		Matcher comb = padrao.matcher(f);
		
		if (comb.find()) {
			return comb.end();
		}
		return -1;
	}
}



