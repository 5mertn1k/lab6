import java.lang.reflect.InvocationTargetException;
import human.ValidateException;

public class ValidateProcessor {
    public static void process(Object object) throws ValidateException {
        Class<?> clazz = object.getClass();

        // Проверяем, аннотирован ли класс @Validate
        if (!clazz.isAnnotationPresent(Validate.class)) {
            throw new IllegalArgumentException("Класс " + clazz.getSimpleName() + " не аннотирован @Validate");
        }

        // Получаем аннотацию и список валидаторов
        Validate validateAnnotation = clazz.getAnnotation(Validate.class);
        Class<?>[] validators = validateAnnotation.value();

        for (Class<?> validatorClass : validators) {
            try {
                // Создаём экземпляр валидатора
                Object validatorInstance = validatorClass.getDeclaredConstructor().newInstance();

                // Проверяем, реализует ли валидатор интерфейс Validator
                if (!(validatorInstance instanceof Validator<?>)) {
                    throw new IllegalArgumentException("Класс " + validatorClass.getSimpleName() + " не реализует интерфейс Validator");
                }

                // Приводим валидатор к типу Validator
                Validator<Object> validator = (Validator<Object>) validatorInstance;

                // Вызываем метод validate
                validator.validate(object);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException("Ошибка создания валидатора " + validatorClass.getSimpleName(), e);
            }
        }
    }
}