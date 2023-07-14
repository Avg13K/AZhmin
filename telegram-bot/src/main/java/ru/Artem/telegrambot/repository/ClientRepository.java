package ru.Artem.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Artem.telegrambot.model.Client;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clients", itemResourceRel = "clients", path = "clients")
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByName(String name);
}