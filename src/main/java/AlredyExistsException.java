public class AlredyExistsException extends RuntimeException {
    public AlredyExistsException(int id) {
        super("Товар с номером " + id + "уже существует");
    }
}
