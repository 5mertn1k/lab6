import java.util.Arrays;

public class CacheProcessor {
    public static void processCache(Class<?> clazz) {
        // Проверяем, есть ли у класса аннотация @Cache
        if (clazz.isAnnotationPresent(Cache.class)) {
            // Получаем аннотацию
            Cache cacheAnnotation = clazz.getAnnotation(Cache.class);

            // Читаем значение свойства value
            String[] cacheValues = cacheAnnotation.value();
            if (cacheValues.length > 0) {
                System.out.println("Класс " + clazz.getSimpleName() + " кэширует следующие данные: "
                        + Arrays.toString(cacheValues));
            } else {
                System.out.println("Класс " + clazz.getSimpleName() + " не имеет данных для кэширования.");
            }
        } else {
            System.out.println("Аннотация @Cache отсутствует у класса " + clazz.getSimpleName());
        }
    }
}