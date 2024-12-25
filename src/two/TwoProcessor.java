
public class TwoProcessor {
    public static void process(Class<?> clazz) {
        // Проверяем, есть ли на классе аннотация @Two
        if (!clazz.isAnnotationPresent(Two.class)) {
            throw new IllegalArgumentException("Класс " + clazz.getSimpleName() + " не аннотирован @Two");
        }

        // Извлекаем аннотацию
        Two twoAnnotation = clazz.getAnnotation(Two.class);

        // Считываем свойства аннотации
        String first = twoAnnotation.first();
        int second = twoAnnotation.second();

        // Выводим свойства
        System.out.println("Аннотация @Two на классе " + clazz.getSimpleName() + ":");
        System.out.println("  first = " + first);
        System.out.println("  second = " + second);
    }
}