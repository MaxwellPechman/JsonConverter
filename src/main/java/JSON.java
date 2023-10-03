public final class JSON {

    private JSON() {
        // Empty Constructor
    }

    public static String toJsonString(Object object) throws IllegalAccessException {
        return JsonStringifier.stringifyObject(object);
    }
}