package org.java.shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.java.shop.entity.Cart;
import org.java.shop.entity.Item;
import org.java.shop.entity.Role;
import org.java.shop.entity.User;
import org.java.shop.repository.CartRepository;
import org.java.shop.repository.ItemRepository;
import org.java.shop.repository.RoleRepository;
import org.java.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InitDbService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @PostConstruct
    public void init() {
	Role roleUser = new Role();
	roleUser.setName("ROLE_USER");
	roleRepository.save(roleUser);

	Role roleAdmin = new Role();
	roleAdmin.setName("ROLE_ADMIN");
	roleRepository.save(roleAdmin);

	User userAdmin = new User();
	userAdmin.setEnabled(true);
	userAdmin.setName("admin");
	userAdmin.setPassword("admin");
	userAdmin.setEmail("admin@gmail.com");
	List<Role> roles = new ArrayList<Role>();
	roles.add(roleUser);
	roles.add(roleAdmin);
	userAdmin.setRoles(roles);
	userRepository.save(userAdmin);

	Item item1 = new Item();
	item1.setAddeddDate(new Date());
	item1.setDescription("Asus maticna ploca, socket 1150");
	item1.setName("Maticna ploca");
	itemRepository.save(item1);

    }
}
