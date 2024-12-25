//@Default(value = ExampleImplementation.class)
public class Example {
    @Invoke
    public void sayHello() {
        System.out.println("Hello from the @Invoke method!");
    }

    public void anotherMethod() {
        System.out.println("This method is not annotated.");
    }
}