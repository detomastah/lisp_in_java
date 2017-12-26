package lexer;

public class LexerRule {
	public Pattern pattern;
	public TokenType type;
	public LexerRule(Pattern pattern, TokenType type) {
		this.pattern = pattern;
		this.type = type;
	}
}