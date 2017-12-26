package lexer;

import java.util.ArrayList;

public class TokenList {
	private ArrayList<Token> tokens;
	
	TokenList() {
		this.tokens = new ArrayList<Token>();
	}
	
	public void add(Token t) {
		this.tokens.add(t);
	}
	
	public Token get(int index) {
		if (index >= tokens.size())
			return null;
		else
			return tokens.get(index);
	}
	
	public boolean isEmpty() {
		return tokens.size() <= 0;
	}
	
//	public TokenType currentTokenType() {
//		if (isEmpty())
//			return null;
//	
//		return tokens.get(0).type;
//	}
//	
//	public Token currentTokenIs(TokenType t) {
//		if (isEmpty())
//			return null;
//		
//		Token token = tokens.get(0);
//		
//		if (token.type == t) {
//			return token;
//		} else {
//			return null;
//		}
//	}
	
	public Token shift() {
		return tokens.remove(0);
	}
	
	public Token peek() {
		if (isEmpty())
			return null;
		return tokens.get(0);
	}
}
