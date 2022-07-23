package org.marketplace.springwebapp.Marketplace.controllers;

import org.marketplace.springwebapp.Marketplace.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderService {
    private final UsersDao usersDao;

    @Autowired
    public OrderService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping("/{id}")
    public String buy(int userId, int productId) {
        usersDao.buy(userId, productId);
        return "/users/{id}";
    }
}
