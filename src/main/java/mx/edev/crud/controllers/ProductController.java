package mx.edev.crud.controllers;

import mx.edev.crud.config.Configuration;
import mx.edev.crud.domain.Product;
import mx.edev.crud.exceptions.ProductNotFoundException;
import mx.edev.crud.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    // Single item
    @GetMapping("/products/{id}")
    public Product getOne(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(
                ()->new ProductNotFoundException(id)
        );
    }

    @PutMapping("/products/{id}")
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        LOGGER.info("Updating product: [{}], [{}]", id, newProduct);

        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setAvailable(newProduct.isAvailable());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @DeleteMapping("/products")
    public void deleteAll() {
        productRepository.deleteAll();
    }
}