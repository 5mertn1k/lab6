package human;
public class HumanTests {
    public static void testAgeRange(Human human) {
        if (human.getAge() < 1 || human.getAge() > 200) {
            throw new ValidateException("Ошибка в testAgeRange: Возраст человека не в диапазоне от 1 до 200");
        }
    }

    public static void testAgePositive(Human human) {
        if (human.getAge() < 0) {
            throw new ValidateException("Ошибка в testAgePositive: Возраст человека не может быть отрицательным");
        }
    }
}   