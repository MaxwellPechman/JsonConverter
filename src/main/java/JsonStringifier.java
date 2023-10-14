import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public final class JsonStringifier {

    private JsonStringifier() {
        // Empty Constructor
    }

    public static String stringifyObject(Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();

        if(PrimitiveUtils.isPrimitive(objectClass) || objectClass.isPrimitive()) {
            return stringifyPrimitive(object);

        } else if(objectClass.isArray()) {
            return stringifyArray((Object[]) object);

        } else if(object instanceof Collection<?> collection) {
            return stringifyCollection(collection);

        } else if(object instanceof Map<?,?> map) {
            return stringifyMap(map);

        } else if(objectClass.isEnum()) {

        } else if(objectClass.isInterface()) {
            throw new JsonException("Cannot stringify Interface to JSON.");

        } else if(objectClass.isAnnotation()) {
            throw new JsonException("Cannot stringify Annotation to JSON.");

        } else {
            return stringifyNestedObject(object);
        }

        return JsonSyntax.NULL_STRING;
    }

    public static String stringifyNestedObject(Object object) throws IllegalAccessException {
        StringBuilder jsonString = new StringBuilder(String.valueOf(JsonSyntax.START_OBJECT));
        Field[] fields = object.getClass().getDeclaredFields();
        int length = fields.length;

        for(int index = 0; index < length; index++) {
            Field field = fields[index];

            field.setAccessible(true);
            jsonString.append(JsonUtils.wrapString(field.getName()));
            jsonString.append(JsonSyntax.PAIR_SEPARATOR);
            jsonString.append(stringifyObject(field.get(object)));

            if(index < length - 1) {
                jsonString.append(JsonSyntax.PROPERTY_SEPARATOR);
            }
        }

        return jsonString.append(JsonSyntax.END_OBJECT).toString();
    }

    public static String stringifyEnum(Object enumObject) {

        return ""; // Replace
    }

    public static String stringifyMap(Map<?, ?> map) {
        StringBuilder jsonString = new StringBuilder(String.valueOf(JsonSyntax.START_OBJECT));

        return jsonString.append(JsonSyntax.END_OBJECT).toString();
    }

    public static String stringifyArray(Object[] objects) throws IllegalAccessException {
        StringBuilder jsonString = new StringBuilder(String.valueOf(JsonSyntax.START_ARRAY));
        int index = 0;

        for(Object object : objects) {
            jsonString.append(stringifyObject(object));

            if(index < objects.length - 1) {
                jsonString.append(JsonSyntax.PROPERTY_SEPARATOR);
            }

            index++;
        }

        return jsonString.append(JsonSyntax.END_ARRAY).toString();
    }

    public static String stringifyCollection(Collection<?> collection) throws IllegalAccessException {
        StringBuilder jsonString = new StringBuilder(String.valueOf(JsonSyntax.START_ARRAY));
        int index = 0;

        for(Object object : collection) {
            jsonString.append(stringifyObject(object));

            if(index < collection.size() - 1) {
                jsonString.append(JsonSyntax.PROPERTY_SEPARATOR);
            }

            index++;
        }

        return jsonString.append(JsonSyntax.END_ARRAY).toString();
    }

    public static String stringifyPrimitive(Object object) {
        Class<?> objectClass = object.getClass();

        if(PrimitiveUtils.isBoolean(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isByte(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isShort(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isInteger(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isLong(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isFloat(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isDouble(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isCharacter(objectClass)) {
            return String.valueOf(object);

        } else if(PrimitiveUtils.isString(objectClass)) {
            return JsonUtils.wrapString(String.valueOf(object));

        } else {
            return JsonSyntax.NULL_STRING;
        }
    }
}