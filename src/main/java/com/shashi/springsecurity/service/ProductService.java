package com.shashi.springsecurity.service;

import com.shashi.springsecurity.entity.Product;
import com.shashi.springsecurity.entity.UserInfo;
import com.shashi.springsecurity.repository.ProductRepository;
import com.shashi.springsecurity.repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = null;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ProductRepository  productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*@PostConstruct
    public void loadProductsFromDB() {
        productList = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Product.builder()
                        .productId(i)
                        .name("product " + i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextInt(5000)).build()
                ).collect(Collectors.toList());
    }*/


    public List<Product> getProducts() {
        productList = productRepository.findAll();
        return productList;
    }

    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }


    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "user added to system ";
    }

    public String addProducts(int count) {
        productList = IntStream.rangeClosed(1, count)
                .mapToObj(i -> Product.builder()
                        .productId(i)
                        .name("product " + i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextInt(5000)).build()
                ).collect(Collectors.toList());

        productRepository.saveAll(productList);

        //productRepository.save(product);

        return "product added to system ";
    }

    public List<UserInfo> getUsers() {
        return userInfoRepository.findAll();
    }
}
