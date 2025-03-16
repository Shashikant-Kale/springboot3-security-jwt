package com.shashi.springsecurity.repository;

// create a repository interface ProductRepository which extends JpaRepository for Product entity. The primary key of the entity is of type Integer. The repository should have create, read, update, delete operations for the entity.


import com.shashi.springsecurity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
