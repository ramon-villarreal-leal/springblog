package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String viewLoginPage(){
        return "login";
    }




    @PostMapping("/login")
    public String viewLoginPage(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model){
        ArrayList<String> ads = new ArrayList<String>();
        boolean isLoggedIn = false;
        ads.add("ad 1");
        ads.add("ad 1");
        ads.add("ad 1");



        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("ads", ads);
        model.addAttribute("isLoggedIn", isLoggedIn);

        return "login";
    }



}
