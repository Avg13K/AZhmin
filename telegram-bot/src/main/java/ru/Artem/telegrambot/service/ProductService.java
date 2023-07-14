package ru.Artem.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Artem.telegrambot.model.Category;
import ru.Artem.telegrambot.model.Product;
import ru.Artem.telegrambot.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void saveAll(List<Product> productList){
        productRepository.saveAll(productList);
    }

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product update(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findByCategory(Category category){
        return productRepository.findByCategory(category);
    }

    public Product createProduct(String name, String desription, Double price, Category category){
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setDescription(desription);
        product.setPrice(price);
        return productRepository.save(product);
    }
}
