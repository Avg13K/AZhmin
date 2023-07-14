package ru.Artem.telegrambot.model;

import javax.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue
    private  Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ClientOrder clientOrder;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Product product;

    @Column(nullable = false)
    private Long countProduct;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public ClientOrder getOrder() {return clientOrder;}
    public void setOrder(ClientOrder clientOrder) {this.clientOrder = clientOrder;}
    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}
    public Long getCountProduct() {return countProduct;}
    public void setCountProduct(Long countProduct) {this.countProduct = countProduct;}
}
