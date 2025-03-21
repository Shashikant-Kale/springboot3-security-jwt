package com.shashi.springsecurity.service;

//create junit test class ProductServiceTest for testing ProductService class
import com.shashi.springsecurity.entity.Product;
import com.shashi.springsecurity.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @Test
    public void testGetProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "product1", 100, 1000));
        products.add(new Product(2, "product2", 200, 2000));
        products.add(new Product(3, "product3", 300, 3000));

        when(repository.findAll()).thenReturn(products);

        List<Product> result = service.getProducts();

        assertEquals(3, result.size());
        assertEquals(1, result.get(0).getProductId());
        assertEquals("product1", result.get(0).getName());
        assertEquals(1000, result.get(0).getPrice());

        assertEquals(2, result.get(1).getProductId());
        assertEquals("product2", result.get(1).getName());
        assertEquals(2000, result.get(1).getPrice());

        assertEquals(3, result.get(2).getProductId());
        assertEquals("product3", result.get(2).getName());
        assertEquals(3000, result.get(2).getPrice());
    }

    @Test
    public void testGetProduct() {
        Product product = new Product(1, "product1", 100, 1000);

        when(repository.findById(1)).thenReturn(java.util.Optional.of(product));

        Product result = service.getProduct(1);

        assertEquals(1, result.getProductId());
        assertEquals("product1", result.getName());
        assertEquals(1000, result.getPrice());
    }

    @Test
    public void testAddProducts() {
        when(repository.save(new Product(1, "product1", 100, 1000))).thenReturn(new Product(1, "product1", 100, 1000));

        String result = service.addProducts(1).trim();

        assertEquals("product added to system", result);
    }
}
