package com.example.PP_31.__SpringBoot.controller;

import com.example.PP_31.__SpringBoot.model.User;
import com.example.PP_31.__SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String show(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("allUsers", users);
        return "users";
    }

    @PostMapping("/users/add")
    public String add(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int age,
            Model model
    ) {
        User user = new User(name, surname, age);
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/users/update")
    public String update(@RequestParam long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/users/update")
    public String saveUpdate(@RequestParam long id,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int age)
    {
        User user = userService.findById(id);
        user.setUsername(name);
        user.setSurname(surname);
        user.setAge(age);
        userService.update(user);
        return "redirect:/";
    }

    @PostMapping("/users/delete")
    public String delete(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
