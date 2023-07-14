package ru.Artem.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Artem.telegrambot.model.Category;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "categories", itemResourceRel = "categories", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long parentId);

    Category findByName(String name);
}