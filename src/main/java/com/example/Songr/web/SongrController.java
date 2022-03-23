package com.example.Songr.web;


import com.example.Songr.Models.Albums;
import com.example.Songr.Repositries.SongrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongrController {

    @Autowired
    SongrRepository songrRepository;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/hello")
    String hello (@RequestParam(name = "name",required = false,defaultValue = "user")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/capitalize")
    String capitalize(@RequestParam(name ="text", required = false,defaultValue = "text")String text ,Model model){
        String upperCase = text.toUpperCase();
        model.addAttribute("text",text);
        model.addAttribute("upperCase",upperCase);
        return "capitalize";
    }
    @PostMapping("/addalbum")
    public RedirectView addAlbum(@ModelAttribute Albums albums){
        songrRepository.save(albums);
        return new RedirectView("allAlbum");
    }
    

    @GetMapping("/allAlbum")
    public String gitAllAlbum(Model model){
        model.addAttribute("albumsList",songrRepository.findAll());
        return "index";
    }

    @ResponseBody
    @GetMapping("/Album")
    List<Albums> albums(Model model){
        List<Albums>albums= new ArrayList<>();
//        albums.add(new Albums("Godzila","Eminem",20,240,"Link"));
        return albums;
    }

}
