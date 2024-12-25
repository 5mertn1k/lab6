public class AnotherExample {
    @Default(value = String.class) // Указываем класс, связанный с полем
    private Object field;

    public Object getField() {
        return field;
    }
}