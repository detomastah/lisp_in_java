package parser;

import java.util.ArrayList;

import lexer.Token;
import lexer.TokenList;
import lexer.TokenType;

public class Parser {
	private TokenList tokens;
	private int lineNumber, colNumber;

	public Parser(TokenList tokens) {
		this.tokens = tokens;
		this.lineNumber = this.colNumber = 1;
	}
	
	public SyntaxObject parse() {
		RootObject root = new RootObject();
		parseRootItems(root.items);
		return root;
	}
	
	private SyntaxObject parseList() {
		Token apostropheToken = tokens.peek();
		boolean evalList = apostropheToken != null && apostropheToken.type == TokenType.APOSTROPHE;
		
		if (evalList) 
			tokens.shift();
		
		Token lBracket = accept(TokenType.L_BRACKET); 
		
		ListObject list = new ListObject(lBracket);
		
		parseListItems(list.items);
		
		System.out.println("DEBUG");
			
		if (accept(TokenType.R_BRACKET, null) == null) {
			fail("Expected )", this.lineNumber, this.colNumber);
		}

		return list;
	}

	private void parseRootItems(ArrayList<SyntaxObject> items) {
		while (!tokens.isEmpty()) {		
					items.add(parseList());
		};
	}
	
	private void parseListItems(ArrayList<SyntaxObject> items) {
		do {
			Token nextToken = tokens.get(0);
			
			if (nextToken == null)
				return;
			
			switch (nextToken.type) {
				case L_BRACKET:
					items.add(parseList());
					break;
				case STRING:
					items.add(parseString());
					break;
				case DIGIT_SEQ:
					items.add(parseNumber());
					break;
				case ALPHA_SEQ:
					items.add(parseIdentifier());
					break;
				default:
//					fail("Unexpected token " + nextToken.lexeme, nextToken.lineNumber, nextToken.colNumber);
					return;
			}
		} while (true);
	}
	
	private SyntaxObject parseString() {
		Token string = accept(TokenType.STRING);
		SyntaxObject so = new StringObject(string);
		return so;
	}
	
	private SyntaxObject parseIdentifier() {
		Token identifier = accept(TokenType.ALPHA_SEQ);
		SyntaxObject so = new IdentifierObject(identifier);
		return so;
	}
	
	private SyntaxObject parseNumber() {
		Token integer = accept(TokenType.DIGIT_SEQ);
		Token dotToken = tokens.peek();
		if (dotToken != null && dotToken.type == TokenType.DOT) {
			Token dot = accept(TokenType.DOT);
			Token floating = accept(TokenType.DIGIT_SEQ);
			if (floating == null) {
				fail("Expected fractional part after dot", this.lineNumber, this.colNumber);
			}
			SyntaxObject so = new FloatObject(
					integer,
					Float.parseFloat(integer.lexeme + '.' + floating.lexeme)
					);
			return so;
		} else {
			SyntaxObject so = new IntegerObject(
					integer,
					Integer.parseInt(integer.lexeme)
					);
			return so;
		}
	}
	
	private Token accept(TokenType t) {
		return accept(t, null);
	}
	
	private Token accept(TokenType t, String errorMessage) {
		Token token = tokens.peek();

		if (token == null)
			fail("Expected " + t.name() + " but EOF reached", lineNumber, colNumber);
			
		if (token.type == t) {
			tokens.shift();
			this.lineNumber = token.lineNumber;
			this.colNumber = token.colNumber + token.lexeme.length();
		} else {
			if (errorMessage == null)
				errorMessage = "Expected " + t.name() + ", got " + token.type.name() + " instead";
			fail(errorMessage, token.lineNumber, token.colNumber);
		}
		
		return token;
	}
	
	private void fail(String message, int lineNumber, int colNumber) {
		String res = String.format("Error at line %d column %d: ", lineNumber, colNumber);
		res += message;
		throw new RuntimeException(res);
	}
	
}
