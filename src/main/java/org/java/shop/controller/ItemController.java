package org.java.shop.controller;

import javax.validation.Valid;

import org.java.shop.entity.Item;
import org.java.shop.entity.User;
import org.java.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ModelAttribute("item")
    public Item construct() {
	return new Item();
    }

    @RequestMapping("/items")
    public String items(Model model) {
	model.addAttribute("items", itemService.findAll());
	return "items";
    }

    @RequestMapping("/add-item")
    public String showAddItems() {
	return "add-item";
    }

    @RequestMapping("/items/remove/{id}")
    public String deleteItem(@PathVariable int id) {
	itemService.deleteOne(id);
	return "redirect:/items.html";
    }

    @RequestMapping("/items/{id}")
    public String detail(Model model, @PathVariable int id) {
	model.addAttribute("item", itemService.findOne(id));
	return "item-detail";
    }

    @RequestMapping(value = "/add-item", method = RequestMethod.POST)
    public String doAddItem(@Valid @ModelAttribute("item") Item item,
	    BindingResult result) {
	if (result.hasErrors()) {
	    return "add-item";
	}
	itemService.save(item);
	return "redirect:/add-item.html?success=true";
    }

}
