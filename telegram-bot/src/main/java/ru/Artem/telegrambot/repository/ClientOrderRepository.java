package ru.Artem.telegrambot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Artem.telegrambot.model.Client;
import ru.Artem.telegrambot.model.ClientOrder;

import java.util.List;

@RepositoryRestResource(path = "ClientOrders", collectionResourceRel="ClientOrders", itemResourceRel="ClientOrder")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

    List<ClientOrder> findByClient(Client client);

    List<ClientOrder> findByClientId(Long clientId);
}