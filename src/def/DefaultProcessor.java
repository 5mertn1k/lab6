import java.lang.reflect.Field;

public class DefaultProcessor {
    public static void processAnnotations(Object object) {
        Class<?> clazz = object.getClass();

        // Проверяем, аннотирован ли сам класс
        if (clazz.isAnnotationPresent(Default.class)) {
            Default defaultAnnotation = clazz.getAnnotation(Default.class);
            System.out.println("Аннотация @Default для класса указывает на: " + defaultAnnotation.value().getName());
        }

        // Проверяем поля
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Default.class)) {
                Default defaultAnnotation = field.getAnnotation(Default.class);
                field.setAccessible(true); // Разрешаем доступ к private полям

                try {
                    // Устанавливаем значение по умолчанию
                    field.set(object, defaultAnnotation.value().getConstructor().newInstance());
                    System.out.println("Поле " + field.getName() + " установлено значением класса: " + defaultAnnotation.value().getName());
                } catch (Exception e) {
                    System.err.println("Ошибка при установке значения для поля: " + field.getName());
                }
            }
        }
    }
}