package com.butenko.vladyslav.foxconstructions.controller.admin;

import com.butenko.vladyslav.foxconstructions.service.implementations.PhotoServiceImpl;
import com.butenko.vladyslav.foxconstructions.service.implementations.UserServiceImpl;
import com.butenko.vladyslav.foxconstructions.service.interfaces.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.service")
@RequestMapping(value = "/admin/category")
public class AdminCategoriesController {
    private final ProductCategoryService productCategoryService;

    private final PhotoServiceImpl photoService;

    private final UserServiceImpl userService;

    @Autowired
    public AdminCategoriesController(ProductCategoryService productCategoryService,
                                     PhotoServiceImpl photoService,
                                     UserServiceImpl userService) {
        this.productCategoryService = productCategoryService;
        this.photoService = photoService;
        this.userService = userService;
    }

    @GetMapping(value = {"", "/"})
    public ModelAndView viewAllProductCategories() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories", this.productCategoryService.getAll());
        modelAndView.addObject("authenticated_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("category/admin/all");
        return modelAndView;
    }


}
