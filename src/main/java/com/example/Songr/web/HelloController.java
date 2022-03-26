package com.example.Songr.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HelloController {

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/hello")
    String hello (@RequestParam(name = "name",required = false,defaultValue = "user")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/capitalize/{text}")
    String capitalize(@PathVariable String text ,Model model){
        String upperCase = text.toUpperCase();
        model.addAttribute("text",text);
        model.addAttribute("upperCase",upperCase);
        return "capitalize";
    }
}
