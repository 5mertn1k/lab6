
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Применима только к методам
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения

public @interface Invoke {
}
