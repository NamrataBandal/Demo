package com.ecommerce.shoppingwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shoppingwebsite.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
