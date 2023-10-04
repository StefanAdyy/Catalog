package com.example.examen_tw.controller;

import com.example.examen_tw.entity.AppUserEntity;
import com.example.examen_tw.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    AppUserService appUserService;

    @GetMapping()
    public String open(Model model){
        AppUserEntity newUser = new AppUserEntity();

        model.addAttribute("newUser", newUser);

        return "register";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") AppUserEntity user, Model model){
        appUserService.saveUser(user);

        List<AppUserEntity> usersList = appUserService.findAll();
        model.addAttribute("usersList", usersList);

        return "users";
    }

}
