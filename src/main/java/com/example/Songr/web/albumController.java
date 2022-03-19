package com.example.Songr.web;


import com.example.Songr.domain.Albums;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
public class albumController {


//    @ResponseStatus(value = HttpStatus.OK)
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

    @ResponseBody
    @GetMapping("/Album")
    List<Albums> albums(Model model){
        List<Albums>albums= new ArrayList<>();
        albums.add(new Albums("Godzilla","Eminem",20,240,"Link"));
        albums.add(new Albums("Bad","Michael Jackson",11,320,"Link"));
        albums.add(new Albums("This is Acting","Sia",9,260,"Link"));
        return albums;
    }

}
