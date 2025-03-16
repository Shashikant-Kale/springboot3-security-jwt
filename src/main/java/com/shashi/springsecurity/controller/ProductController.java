package com.shashi.springsecurity.controller;

// create a controller class ProductController with a all methods in ProductService
import com.shashi.springsecurity.entity.Product;
import com.shashi.springsecurity.entity.UserInfo;
import com.shashi.springsecurity.service.JwtService;
import com.shashi.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/allUsers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserInfo> allUsers() {
        return service.getUsers();
    }

    @PostMapping("/addProducts")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String addProducts(@RequestParam Integer count) {
        return service.addProducts(count);
    }


    @GetMapping("/allProducts")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
}


