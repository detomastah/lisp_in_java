package lexer;

public class LispLexer extends Lexer {
	LexerRule stringRule() {
		Pattern string_start = new Pattern(new CharMatcher('\"'), false);
		Pattern string_contents = new Pattern(new NotCharMatcher('\"'), false);
		Pattern string_end = new Pattern(new CharMatcher('\"'), true);
		
		string_start.addNext(string_contents);
		string_contents.addNext(string_contents);
		string_contents.addNext(string_end);
		return new LexerRule(string_start, TokenType.STRING);
	}
	
	LexerRule charSeqRule() {
	    return new LexerRule(new Pattern(new AlphaMatcher(), true), TokenType.ALPHA_SEQ);
	}
	
	LexerRule digitSeqRule() {
	    return new LexerRule(new Pattern(new NumMatcher(), true), TokenType.DIGIT_SEQ);
	}
	
	LexerRule lBracketRule() {
	    Pattern p1 = new Pattern(new CharMatcher('('), true);
	    return new LexerRule(p1, TokenType.L_BRACKET);
	}
	
	LexerRule rBracketRule() {
	  Pattern p1 = new Pattern(new CharMatcher(')'), true);
	  return new LexerRule(p1, TokenType.R_BRACKET);
	}
	
	LexerRule apostropheRule() {
		  Pattern p1 = new Pattern(new CharMatcher('\''), true);
		  return new LexerRule(p1, TokenType.APOSTROPHE);
		}
	
	LexerRule dotRule() {
	  Pattern p1 = new Pattern(new CharMatcher('.'), true);
	  return new LexerRule(p1, TokenType.DOT);
	}
	
	public LispLexer(String str) {
		super(str);
		rules.add(stringRule());
		rules.add(charSeqRule());
		rules.add(digitSeqRule());
		rules.add(lBracketRule());
		rules.add(rBracketRule());
		rules.add(dotRule());
	}
}
