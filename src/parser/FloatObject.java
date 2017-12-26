package parser;

import lexer.Token;

public class FloatObject extends SyntaxObject {
	float value;
	
	FloatObject(Token decimal, float value) {
		super(SyntaxObject.SyntaxObjectType.FLOAT, decimal);
		this.value = value;
	}

	@Override
	void print() {
		System.out.print(" ");
		System.out.print(value);
		System.out.print(" ");
	}
}