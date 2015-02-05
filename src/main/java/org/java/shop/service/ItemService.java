package org.java.shop.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.java.shop.entity.Item;
import org.java.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void save(Item item) {
	item.setName(item.getName());
	item.setAddeddDate(new Date());
	item.setDescription(item.getDescription());
	itemRepository.save(item);
    }

    public Item findOne(int id) {
	return itemRepository.findOne(id);
    }

    public List<Item> findAll() {
	return itemRepository.findAll();
    }

    public void deleteOne(int id) {
	itemRepository.delete(id);

    }

}
