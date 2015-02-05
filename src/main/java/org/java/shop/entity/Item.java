package org.java.shop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 5, message = "Password must be at least 15 characters long")
    private String description;

    @Column(name = "added_date")
    private Date addeddDate;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Date getAddeddDate() {
	return addeddDate;
    }

    public void setAddeddDate(Date addeddDate) {
	this.addeddDate = addeddDate;
    }

    public Cart getCart() {
	return cart;
    }

    public void setCart(Cart cart) {
	this.cart = cart;
    }

}
