package parser;

import lexer.Token;

public class IdentifierObject extends SyntaxObject {
	String value;
	
	IdentifierObject(Token id) {
		super(SyntaxObject.SyntaxObjectType.IDENTIFIER, id);
		this.value = id.lexeme;
	}
	
	@Override
	void print() {
		System.out.print(" ");
		System.out.print(value);
		System.out.print(" ");
	}
}
