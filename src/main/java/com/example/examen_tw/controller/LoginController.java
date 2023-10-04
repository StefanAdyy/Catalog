package com.example.examen_tw.controller;

import com.example.examen_tw.entity.AppUserEntity;
import com.example.examen_tw.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired private AppUserService appUserService;

    @GetMapping("")
    public String login(Model model){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String open(Model model){
        AppUserEntity appUserEntity = new AppUserEntity();
        model.addAttribute("user", appUserEntity);

        return "login";
    }

    @PostMapping("/login/loginUser")
    public String loginUser(@ModelAttribute("user") AppUserEntity user){
        if (appUserService.checkUsername(user)==null){
            return "login";
        }

        return "redirect:/users";
    }

}
