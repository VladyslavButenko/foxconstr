package com.butenko.vladyslav.foxconstructions.controller.admin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.service")
@RequestMapping(value = "/admin/category")
public class AdminCategoriesController {

}
