package org.java.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @Size(min = 3, message = "Email must be in propper format")
    @Email
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;

    private Boolean enabled;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    @OneToOne
    private Cart cart;

    public List<Role> getRoles() {
	return roles;
    }

    public void setRoles(List<Role> roles) {
	this.roles = roles;
    }

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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Boolean getEnabled() {
	return enabled;
    }

    public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
    }

    public Cart getCart() {
	return cart;
    }

    public void setCart(Cart cart) {
	this.cart = cart;
    }

}
