package com.lumiselene.LumiseleneDesigns.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/get")
    @ResponseBody
    public String welcome() {
        return "home";
    }
}
