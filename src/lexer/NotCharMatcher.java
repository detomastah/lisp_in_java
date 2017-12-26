package lexer;

public class NotCharMatcher extends CharMatcher {
	public NotCharMatcher(char character) {
		super(character);
	}
	
	@Override
	public int _match(String str, int pos) {
		return (str.charAt(pos) != character) ? 1 : -1;
	}
}
