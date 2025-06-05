import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductRepositoryTest {

    Product item1 = new Product(15, "Телефон", 15_000);
    Product item2 = new Product(7, "Книга", 3_000);
    Product item3 = new Product(37, "Кукла", 1_500);

    @Test
    public void removeId() {
        ProductRepository repo = new ProductRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.remove(7);
        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void remove() {
        ProductRepository repo = new ProductRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.remove(5);
        });
    }
}
