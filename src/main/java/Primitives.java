public final class Primitives {

    private Primitives() {
        // Empty Constructor
    }

    public static boolean isPrimitive(Class<?> clazz) {
        return isBoolean(clazz)
                || isByte(clazz)
                || isShort(clazz)
                || isInteger(clazz)
                || isLong(clazz)
                || isFloat(clazz)
                || isDouble(clazz)
                || isCharacter(clazz)
                || isString(clazz);
    }

    public static boolean isBoolean(Class<?> clazz) {
        return clazz == boolean.class || clazz == Boolean.class;
    }

    public static boolean isByte(Class<?> clazz) {
        return clazz == byte.class || clazz == Byte.class;
    }

    public static boolean isShort(Class<?> clazz) {
        return clazz == short.class || clazz == Short.class;
    }

    public static boolean isInteger(Class<?> clazz) {
        return clazz == int.class || clazz == Integer.class;
    }

    public static boolean isLong(Class<?> clazz) {
        return clazz == long.class || clazz == Long.class;
    }

    public static boolean isFloat(Class<?> clazz) {
        return clazz == float.class || clazz == Float.class;
    }

    public static boolean isDouble(Class<?> clazz) {
        return clazz == double.class || clazz == Double.class;
    }

    public static boolean isCharacter(Class<?> clazz) {
        return clazz == char.class || clazz == Character.class;
    }

    public static boolean isString(Class<?> clazz) {
        return clazz == String.class;
    }
}