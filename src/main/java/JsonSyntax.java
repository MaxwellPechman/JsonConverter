public class JsonSyntax {

    public static final String NULL_STRING = "null";

    public static final char START_OBJECT = '{';
    public static final char END_OBJECT = '}';
    public static final char START_ARRAY = '[';
    public static final char END_ARRAY = ']';
    public static final char WRAPPER = '"';
    public static final char PAIR_SEPARATOR = ':';
    public static final char PROPERTY_SEPARATOR = ',';

    private JsonSyntax() {
        // Empty Constructor
    }

    public static boolean containsToken(String string) {
        if(!string.isEmpty()) {
            for(int index = 0; index < string.length(); index++) {
                for(char token : getSyntax()) {
                    return token == string.charAt(index);
                }
            }
        }

        return false;
    }

    public static char[] getSyntax() {
        return new char[]{
                START_OBJECT,
                END_OBJECT,
                START_ARRAY,
                END_ARRAY,
                WRAPPER,
                PAIR_SEPARATOR,
                PROPERTY_SEPARATOR
        };
    }
}
