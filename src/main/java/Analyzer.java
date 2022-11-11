import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

    public void analyze(String text, List<PatternWithName> patterns) {
        text = text.replaceAll(Patterns.COMMENT, " ");

        List<Token> tokens = new ArrayList<>();
        boolean[] matched = new boolean[text.length()];

        for (PatternWithName pattern : patterns) {
            Matcher m = pattern.pattern.matcher(text);
            while (m.find()) {
                if (match(matched, m.start(), m.end() - 1)) {
                    tokens.add(new Token(m.start(), m.group(0), pattern.name));
                }
            }
        }

        tokens.sort(Comparator.comparingInt(t -> t.start));
        tokens.forEach(token -> System.out.println(token.value + " - " + token.type));
    }

    private boolean match(boolean[] matched, int l, int r) {
        assert l <= r;
        for (int i = l; i <= r; i++) {
            if (matched[i]) {
                return false;
            }
            matched[i] = true;
        }
        return true;
    }

    public static class PatternWithName {
        private Pattern pattern;
        private String name;

        public PatternWithName(Pattern pattern, String name) {
            this.pattern = pattern;
            this.name = name;
        }
    }

    private class Token {
        private int start;
        private String value;
        private String type;

        public Token(int start, String value, String type) {
            this.start = start;
            this.value = value;
            this.type = type;
        }
    }
}