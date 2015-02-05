package org.java.shop.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.java.shop.entity.Cart;
import org.java.shop.entity.Role;
import org.java.shop.entity.User;
import org.java.shop.repository.CartRepository;
import org.java.shop.repository.RoleRepository;
import org.java.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<User> findAll() {
	return userRepository.findAll();
    }

    public void deleteOne(int id) {
	userRepository.delete(id);
    }

    public User findOne(int id) {
	return userRepository.findOne(id);
    }

    public void save(User user) {
	user.setEnabled(true);
	user.setPassword(user.getPassword());
	List<Role> roles = new ArrayList<Role>();
	roles.add(roleRepository.findByName("ROLE_USER"));
	user.setRoles(roles);
	Cart cart = new Cart();
	cartRepository.save(cart);
	user.setCart(cart);
	userRepository.save(user);
    }

}
