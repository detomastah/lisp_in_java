package lexer;

import java.util.ArrayList;

public class Pattern {
	public ArrayList<Pattern> next;
	public Matcher matcher;
	public Boolean terminal;
	
	public Pattern(Matcher matcher, Boolean terminal) {
		this.next = new ArrayList<Pattern>();
		this.matcher = matcher;
		this.terminal = terminal;
	}
	
	public void addNext(Pattern pattern) {
		next.add(pattern);
	}
}
