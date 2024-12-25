public class HumanTests1 {
    public static void testAge(Human1 human) {
        if (human.getAge() < 1 || human.getAge() > 200) {
            throw new ValidateException("Ошибка в testAge: возраст человека не в диапазоне от 1 до 200.");
        }
    }
}