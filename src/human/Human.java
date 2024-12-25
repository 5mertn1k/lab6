package human;

public class Human {
    private final int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human(age=" + age + ")";
    }
}