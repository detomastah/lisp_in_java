package parser;

import lexer.Token;

public class IntegerObject extends SyntaxObject {
	int value;
	
	IntegerObject(Token integer, int value) {
		super(SyntaxObject.SyntaxObjectType.INTEGER, integer);
		this.value = value;
	}

	@Override
	void print() {
		System.out.print(" ");
		System.out.print(value);
		System.out.print(" ");
	}
}
