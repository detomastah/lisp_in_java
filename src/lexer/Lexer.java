package lexer;

import java.util.ArrayList;

public class Lexer {
//	public class Ref<T>
//	{
//	    public T Value;
//	    public Ref(T value)
//	    {
//	        Value = value;
//	    }
//	}
	
	private int position, line_number, line_position;
	private String str;
	ArrayList<LexerRule> rules;
	
	public Lexer(String str) {
		this.str = str;
		this.rules = new ArrayList<LexerRule>();
	}

	private void skipWhitespace() {
		while (position < str.length() && (str.charAt(position) == ' ' || str.charAt(position) == '\n')) {
	    	if (str.charAt(position) == '\n') {
	    		line_number++;
	    		line_position = position;
	    	}
	    	position++;
		}
	}

	public TokenList tokenize() {
		TokenList tokens = new TokenList();
	    position = 0;
	    line_position = -1;
	    line_number = 1;
	
	    skipWhitespace();
	    
	    while (position < str.length()) {
	        Boolean matched = false;
	
	        for (LexerRule rule : rules) {            
	            int result = match_pattern(position, rule.pattern);
	
	            if (result > 0) {
	               matched = true;
	               System.out.println(rule.type);
	               System.out.println(position);
	               System.out.println(result);

	               tokens.add(new Token(rule.type, str.substring(position, result), line_number, position - line_position));
	               position = result;
	               skipWhitespace();
	               break;
	            }
	        }
	        if (!matched) {
	            System.out.println(
            		String.format("Unrecognized token in line %d, column %d: %s", line_number, position - line_position, str.substring(position))
        		);
	            break;
	        }
	    }
	    return tokens;
    }

    int match_pattern(int position, Pattern pat) {
        int match_length = pat.matcher.match(str, position);

	    if (match_length == -1)
	        return -1;
	
	    if (pat.terminal) {
	        return position + match_length;
	    }
	
	    for (Pattern next_pattern : pat.next ) {
	        int result = match_pattern(position + match_length, next_pattern);
	        if (result != -1)
	        	return result;
	    }
	    
	    return -1;
    }
}
