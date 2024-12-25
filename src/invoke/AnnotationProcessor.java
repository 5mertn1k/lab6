import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void processInvoke(Object object) {
        Class<?> clazz = object.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            // Проверяем, аннотирован ли метод @Invoke
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    // Вызываем аннотированный метод
                    method.invoke(object);
                } catch (Exception e) {
                    System.err.println("Ошибка при вызове метода: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}