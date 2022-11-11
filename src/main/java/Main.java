import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Test.py"))) {
            reader.lines().forEach(s -> {
                text.append(s);
                text.append("\n");
            });
        }

        Analyzer analyzer = new Analyzer();
        analyzer.analyze(text.toString(), buildPatterns());
    }

    private static List<Analyzer.PatternWithName> buildPatterns() {
        List<Analyzer.PatternWithName> patterns = new ArrayList<>();
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.STRING_LITERAL), "string literal"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.CHAR), "char"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.KEYWORD), "keyword"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.IDENTIFIER), "identifier"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.OPERATORS), "operator"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.DECIMAL_LITERAL), "decimal literal"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.BOOL_LITERAL), "bool keyword"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.DELIMITER), "delimiter"));
        patterns.add(new Analyzer.PatternWithName(Pattern.compile(Patterns.COMMENT), "comment"));
        return patterns;
    }
}