package lexer;

public abstract class Matcher {
	protected abstract int _match(String str, int pos);
	
	public int match(String str, int pos) {
		try {
			int result = _match(str, pos);
			return result;
		} catch (java.lang.StringIndexOutOfBoundsException a) {
			return -1;
		}		
	}
}
