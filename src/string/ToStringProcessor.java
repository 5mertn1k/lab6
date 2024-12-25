import java.lang.reflect.Field;

public class ToStringProcessor {
    public static String generateToString(Object object) {
        Class<?> clazz = object.getClass();
        StringBuilder result = new StringBuilder(clazz.getSimpleName() + " {");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);

                if (annotation.value() == ToString.Include.YES) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(object);
                        result.append(field.getName()).append("=").append(value).append(", ");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Ошибка доступа к полю: " + field.getName(), e);
                    }
                }
            }
        }

        // Убираем последнюю запятую и пробел, если они есть
        if (result.length() > clazz.getSimpleName().length() + 2) {
            result.setLength(result.length() - 2);
        }
        result.append("}");
        return result.toString();
    }
}