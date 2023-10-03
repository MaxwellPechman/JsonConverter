import java.util.Collection;
import java.util.Map;

public final class JsonStringifier {

    private JsonStringifier() {
        // Empty Constructor
    }

    public static String stringifyObject(Object object) {
        Class<?> objectClass = object.getClass();

        if(Primitives.isPrimitive(objectClass) || objectClass.isPrimitive()) {
            return stringifyPrimitive(object);

        } else if(objectClass.isArray()) {

        } else if(object instanceof Collection<?> collection) {

        } else if(object instanceof Map<?,?> map) {

        } else if(objectClass.isEnum()) {

        } else if(objectClass.isInterface()) {
            throw new JsonException("Cannot stringify Interface to JSON.");

        } else if(objectClass.isAnnotation()) {
            throw new JsonException("Cannot stringify Annotation to JSON.");

        } else {

        }

        return JsonSyntax.NULL_STRING;
    }

    public static String stringifyCollection(Collection<?> collection) {
        StringBuilder jsonString = new StringBuilder(String.valueOf(JsonSyntax.START_ARRAY));

        return jsonString.append(JsonSyntax.END_ARRAY).toString();
    }

    public static String stringifyPrimitive(Object object) {
        Class<?> objectClass = object.getClass();

        if(Primitives.isBoolean(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isByte(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isShort(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isInteger(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isLong(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isFloat(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isDouble(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isCharacter(objectClass)) {
            return String.valueOf(object);

        } else if(Primitives.isString(objectClass)) {
            return JsonUtils.wrapString(String.valueOf(object));

        } else {
            return JsonSyntax.NULL_STRING;
        }
    }
}