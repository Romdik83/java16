import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product item1 = new Product(15, "Телефон", 15_000);
    Product item2 = new Product(7, "Книга", 3_000);
    Product item3 = new Product(37, "Кукла", 1_500);

    @BeforeEach
    public void setup() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
    }
    @Test
    public void removeId() {
        repo.removeById(7);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.removeById(5);
        });
    }

    @Test
    public void shouldSaveProduct() {

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionSaveProduct() {

        Assertions.assertThrows(AlredyExistsException.class, () -> {
            repo.save(item2);
        });
    }
}
