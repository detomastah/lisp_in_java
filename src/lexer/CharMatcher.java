package lexer;

public class CharMatcher extends Matcher {
	char character;
	
	public CharMatcher(char character) {
		this.character = character;
	}
	
	@Override
	public int _match(String str, int pos) {
		return (str.charAt(pos) == character) ? 1 : -1;
	}
}
