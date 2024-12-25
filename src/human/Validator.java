import java.lang.reflect.Method;

public class Validator {
    public static void validate(Object object, Class<?> testClass) {
        // Получаем все методы из класса тестов
        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {
            try {
                // Проверяем, принимает ли метод объект того же типа
                if (method.getParameterCount() == 1 && method.getParameterTypes()[0].isAssignableFrom(object.getClass())) {
                    method.invoke(null, object); // Вызываем метод с тестируемым объектом
                }
            } catch (Exception e) {
                // Если метод выбрасывает ValidateException, перехватываем его
                Throwable cause = e.getCause();
                if (cause instanceof ValidateException) {
                    throw (ValidateException) cause; // Передаём ValidateException выше
                } else {
                    throw new RuntimeException("Непредвиденная ошибка", e);
                }
            }
        }
    }
}
