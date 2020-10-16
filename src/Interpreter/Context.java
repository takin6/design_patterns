package Interpreter;

import java.util.StringTokenizer;

public class Context {
    // 与えられた文字列をトークンに分割してくれる。ex. ' ', '\t', '\n' ...
    private StringTokenizer tokenizer;
    private String currentToken;
    public Context(String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public String nextToken() {
        // 次のトークンがあるかを調べる
        if (tokenizer.hasMoreTokens()) {
            // 次のトークンを得る
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch(NumberFormatException e) {
            throw new ParseException("Warning; " + e);
        }

        return number;
    }

}
