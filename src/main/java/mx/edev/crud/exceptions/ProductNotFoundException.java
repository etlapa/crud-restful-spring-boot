package mx.edev.crud.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Could not find the product with ID: [" + id + "]");
    }
}