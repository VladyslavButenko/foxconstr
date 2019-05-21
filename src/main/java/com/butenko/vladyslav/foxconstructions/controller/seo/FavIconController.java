package com.butenko.vladyslav.foxconstructions.controller.seo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavIconController {
    @GetMapping(value = "/favicon.ico")
    public String getFavIcon(){
        return "forward:/resources/static/favicon.ico";
    }

}
