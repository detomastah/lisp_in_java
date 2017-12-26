package lexer;

public class NumMatcher extends Matcher {
	private boolean isNum(char c) {
		return (c >= 48 && c <= 57);
	}
	
	@Override
	public int _match(String str, int pos) {
		int i = 0;
	
		while (isNum(str.charAt(pos + i))) {
			i++;
		}
		
		return (i > 0) ? i : -1;
	}
}

