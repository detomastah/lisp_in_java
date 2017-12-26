package lexer;

public class AlphaMatcher extends Matcher {
	private boolean isAlpha(char c) {
		return ((c >= 65 && c <= 90) || (c >= 97 && c <= 122));
	}
	
	@Override
	public int _match(String str, int pos) {
		int i = 0;
	
		while (isAlpha(str.charAt(pos + i))) {
			i++;
		}
		
		return (i > 0) ? i : -1;
	}
	
	
}

