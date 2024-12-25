import java.util.*;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import human.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //1.2
        Human human = new Human(750); // Создаем объект Human с возрастом 750
        System.out.println(human);

        try {
            // Проверяем объект human с использованием тестов из HumanTests
            Validator.validate(human, HumanTests.class);
        } catch (ValidateException e) {
            System.err.println("Exception in thread \"main\": " + e.getMessage());
        }
        //2.1
//        Example example = new Example();
//
//        // Обработка аннотации @Invoke
//        AnnotationProcessor.processInvoke(example);

        //2.2
        AnotherExample example = new AnotherExample();
        DefaultProcessor.processAnnotations(example);

        System.out.println("Поле field: " + example.getField());

    }
}