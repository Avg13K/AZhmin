package ru.Artem.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Artem.telegrambot.repository.CategoryRepository;
import ru.Artem.telegrambot.model.Category;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public void saveAll(List<Category> categoryList){
        categoryRepository.saveAll(categoryList);
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category update(Category category){
        return categoryRepository.save(category);
    }
    public void delete(Category category){
        categoryRepository.delete(category);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

    public Category findByName(String name){
        return categoryRepository.findByName(name);
    }

    public Category createCategory(String name, Long parentId){
        var categoryByName = categoryRepository.findByName(name);
        if (categoryByName == null){
            Category category = new Category();
            category.setName(name);
            var parent = categoryRepository.findById(parentId);
            parent.ifPresent(category::setParent);
            return categoryRepository.save(category);
        } else {
            return categoryByName;
        }
    }
}
