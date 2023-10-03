public final class JsonUtils {

    private JsonUtils() {
        // Empty Constructor
    }

    public static String wrapString(String string) {
        return JsonSyntax.WRAPPER + string + JsonSyntax.WRAPPER;
    }

    public static String unwrapString(String string) {
        String unwrapped = "";
        int length = string.length();

        if(length > 1) {
            if(string.charAt(0) == JsonSyntax.WRAPPER) {

            }

        } else {
            throw new JsonException("String cannot be unwrapped.");
        }

        return unwrapped;
    }
}