import java.util.Collection;
import java.util.Map;

public final class JsonParser {

    private JsonParser() {
        // empty Constructor
    }

    public static <T> T parsePrimitive(T type, String jsonString) {
        Class<?> typeClass = type.getClass();

        if(PrimitiveUtils.isBoolean(typeClass)) {
            return (T) typeClass.cast(Boolean.valueOf(jsonString));

        } else if (PrimitiveUtils.isByte(typeClass)) {
            return (T) typeClass.cast(Byte.valueOf(jsonString));

        } else if(PrimitiveUtils.isShort(typeClass)) {
            return (T) typeClass.cast(Short.valueOf(jsonString));

        } else if(PrimitiveUtils.isInteger(typeClass)) {
            return (T) typeClass.cast(Integer.valueOf(jsonString));

        } else if(PrimitiveUtils.isLong(typeClass)) {
            return (T) typeClass.cast(Long.valueOf(jsonString));

        } else if(PrimitiveUtils.isFloat(typeClass)) {
            return (T) typeClass.cast(Float.valueOf(jsonString));

        } else if(PrimitiveUtils.isDouble(typeClass)) {
            return (T) typeClass.cast(Double.valueOf(jsonString));

        } else if(PrimitiveUtils.isCharacter(typeClass)) {
            return (T) typeClass.cast(Character.valueOf(jsonString.charAt(0)));

        } else if(PrimitiveUtils.isString(typeClass)) {
            return (T) typeClass.cast(jsonString);
        }

        return null;
    }

    public static <T> T parseJson(T type, String jsonString) {
        Class<?> typeClass = type.getClass();

        if(typeClass.isPrimitive() || PrimitiveUtils.isPrimitive(typeClass)) {
            return parsePrimitive(type, jsonString);

        } else if(typeClass.isArray()) {

        } else if(type instanceof Collection<?> collection) {

        } else if(type instanceof Map<?, ?> map) {

        } else if(typeClass.isEnum()) {

        } else if(typeClass.isInterface()) {
            throw new JsonException("Cannot parse JSONString to Interface.");

        } else if(typeClass.isAnnotation()) {
            throw new JsonException("Cannot parse JSONString to Annotation.");

        } else {

        }

        return null;
    }
}
