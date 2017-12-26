package parser;

import java.util.ArrayList;

import lexer.Token;

public abstract class SyntaxObject {
	public enum SyntaxObjectType
	{
	  LIST, STRING, INTEGER, FLOAT, IDENTIFIER, ROOT
	}
	public Token token;
	public int intValue;
	public float floatValue;
	public String stringValue;
	public String identifier;
	
	public 
	
	SyntaxObject(SyntaxObjectType t, Token token) {
		this.token = token;
	}
	
	abstract void print();
}
