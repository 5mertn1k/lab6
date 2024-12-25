@Cache(value = {"users", "products"}) // Аннотация с заполненным значением
public class testcache {
    public void fetchData() {
        System.out.println("Получение данных...");
    }
}