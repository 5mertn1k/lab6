@ToString
public class Person {
    @ToString
    private String name;

    @ToString(ToString.Include.NO) // Поле исключается из строкового представления
    private int age;

    @ToString
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}