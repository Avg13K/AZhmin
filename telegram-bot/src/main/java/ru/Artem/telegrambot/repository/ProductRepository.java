package ru.Artem.telegrambot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Artem.telegrambot.model.Category;
import ru.Artem.telegrambot.model.Product;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", itemResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
}