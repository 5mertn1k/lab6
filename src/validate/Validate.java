import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Для типов и аннотаций
public @interface Validate {
    Class<?>[] value(); // Обязательное свойство, массив классов-валидаторов
}