package lexer;

public class Token {
	public int lineNumber, colNumber;
	public TokenType type;
	public String lexeme;
	
	public Token(TokenType type, String lexeme, int line_number, int col_number) {
		this.type = type;
		this.lexeme = lexeme;
		this.lineNumber = line_number;
		this.colNumber = col_number;
		System.out.print("TOKEN: ");
		System.out.println(this.lexeme);
	}
	

	public boolean isA(TokenType t) {
		return this.type == t;
	}
}


//
//struct Token {
//  Token(string type, string lexem) {
//    this->type = type;
//    this->lexem = lexem;
//    cout << "Token: '" << lexem << "'" << endl;
//  }
//  string type;
//  string lexem;
//};