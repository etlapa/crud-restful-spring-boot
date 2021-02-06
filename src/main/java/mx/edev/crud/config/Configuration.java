package mx.edev.crud.config;

import mx.edev.crud.domain.Product;
import mx.edev.crud.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

    private static final int MAX_ITEMS = 10;

    @Bean
    public CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            for (int i = 1; i <= MAX_ITEMS; i++) {
                LOGGER.info("Preloading " + repository.save(new Product("Product " + i, "Product's description " + i, true)));
            }
        };
    }

}