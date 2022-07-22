package org.marketplace.springwebapp.controllers;

import jakarta.validation.Valid;
import org.marketplace.springwebapp.dao.UsersDao;
import org.marketplace.springwebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("marketplace-spring-webapp/users")
public class UserController {
    private final UsersDao usersDao;

    @Autowired
    public UserController(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersDao.index());
        return "users/index";
    }
    @GetMapping("/{id}")
    public static String showUser(@PathVariable("id") int id, Model model) {
        return "users/{id}";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        usersDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", usersDao.showUser(id));
        return "users/edit";
    }

    @PatchMapping("/{id}/update")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        usersDao.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/destroy")
    public String destroy(@PathVariable("id") int id) {
        usersDao.destroy(id);
        return "redirect:/users";
    }
}
