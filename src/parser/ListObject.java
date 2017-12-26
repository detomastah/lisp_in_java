package parser;

import java.util.ArrayList;

import lexer.Token;

public class ListObject extends SyntaxObject {
	public ArrayList<SyntaxObject> items;
	
	ListObject(Token lBracket) {
		super(SyntaxObject.SyntaxObjectType.LIST, lBracket);
		this.items = new ArrayList<SyntaxObject>();
	}

	@Override
	void print() {
		System.out.print("(");
		for (SyntaxObject s : items) {
			s.print();
		}
		// TODO Auto-generated method stub
		System.out.print(")");
	}
}
