public class Patterns
{
    public static final String DECIMAL_LITERAL = "\\b([0-9]*[.]?[0-9]+([eE][-+]?[0-9]+)?)";

    public static final String BOOL_LITERAL = "\\b(False|True)\\b";

    public static final String STRING_LITERAL = "\"(?:\\\\\"|[^\"])*?\"";

    public static final String KEYWORD = "\\b(import|as|class|def|pass|if|elif|else|try|except|throw|for|while|in|is|await|None|raise|return|and|or|lambda|break|continue|from|assert|with|not|async|yield|global|del|print)\\b";

    public static final String COMMENT = "#.*(\\r|\\n|\\r\\n|$)";

    public static final String OPERATORS = "<(?!=)|\\.|>(?!=)|<=|>=|!=|(?<![<>!=+-/%&^|])=|==|!(?!=)|\\+(?!\\+)|-(?!-)|\\*|/|%|\\+\\+|--|&&|(?!&)&|~|<<|>>(?!>)|>>>";

    public static final String CHAR = "'(\\\\['\"tvrnafb\\\\]|[^'\\\\])'";

    public static final String IDENTIFIER = "\\b[_A-Za-z][0-9A-Za-z_]*\\b";

    public static final String DELIMITER = "[(){};,\\[\\]]";
}