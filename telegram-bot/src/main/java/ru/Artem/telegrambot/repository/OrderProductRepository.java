package ru.Artem.telegrambot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Artem.telegrambot.model.ClientOrder;
import ru.Artem.telegrambot.model.OrderProduct;
import ru.Artem.telegrambot.model.Product;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orderProducts", itemResourceRel = "orderProducts", path = "orderProducts")
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    void deleteByProduct(Product product);

    List<OrderProduct> findByProduct(Product product);

    void deleteByClientOrder(ClientOrder order);

    List<OrderProduct> findByClientOrder(ClientOrder Order);
}
