package com.example.examen_tw.controller;

import com.example.examen_tw.entity.AppUserEntity;
import com.example.examen_tw.repository.AppUserRepository;
import com.example.examen_tw.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired private AppUserService userService;
    @Autowired private AppUserRepository userRepository;

    @GetMapping("/users")
    public String displayUserList(Model model){
        List<AppUserEntity> usersList = userService.findAll();
        model.addAttribute("usersList", usersList);

        return "users";
    }

    @PostMapping("/users/save")
    public String saveUser(AppUserEntity user, RedirectAttributes redirectAttributes){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String displayEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
            Optional<AppUserEntity> user = userService.getUserById(id);
            model.addAttribute("user", user);

            return "user_form";
    }

}
