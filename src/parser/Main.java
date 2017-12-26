package parser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import lexer.*;

public class Main {
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	public static void main(String[] args) {	
		String input;
		try {
			input = readFile("/home/lukasz/lisp/lisp_interpreter/test.lisp", StandardCharsets.UTF_8);
			input += "\n";
			Lexer tokenizer = new LispLexer(input);
			TokenList tokens = tokenizer.tokenize();
			Parser parser = new Parser(tokens);
			SyntaxObject so = parser.parse();
			so.print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
