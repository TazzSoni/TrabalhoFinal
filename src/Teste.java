import View.Tela;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import br.udesc.udescdb.SQLiteBaseListener;
import br.udesc.udescdb.SQLiteLexer;
import br.udesc.udescdb.SQLiteParser;

public class Teste {

	public static void main(String[] args) {
		/*String create = "";
		String insert = "insert into xpto (col1, col2) values (1, 'abc')";
		//String select = "select * from xpto";
		Tela tela = new Tela();
                tela.setVisible(true);
		CodePointCharStream inputStream = CharStreams.fromString(insert);
		SQLiteLexer lexer = new SQLiteLexer(inputStream);
		CommonTokenStream cts = new CommonTokenStream(lexer);
		SQLiteParser parser = new SQLiteParser(cts);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.parse();
			
                SQLiteBaseListener listener = new SQLiteBaseListener();
                
		ParseTreeWalker p = new ParseTreeWalker();
		p.walk(listener, tree);

                System.out.println(listener.getCurrentCommand().toString());*/

                
		// agora vamos pegar as informacoes que o listener capturou e processar o comando 
	}

}
