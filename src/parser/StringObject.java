package parser;

import lexer.Token;

public class StringObject extends SyntaxObject {
	String value;
	
	StringObject(Token string) {
		super(SyntaxObject.SyntaxObjectType.STRING, string);
		this.value = string.lexeme.substring(1, string.lexeme.length()-1);
	}
	
	@Override
	void print() {
		System.out.print(" \"");
		System.out.print(value);
		System.out.print("\" ");
	}

}
