package com.activa.programa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("/admin")
    public String adminLogin() {
        return "adminLogin";
    }
    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "ForgotPassword";
    }
    @GetMapping("/index")
    public String mainPage() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/services")
    public String services() {
        return "services";
    }
    @GetMapping("/adminCatalog")
    public String adminCatalog() {
        return "administrativeCatalog";
    }
    @GetMapping("/customCatalog")
    public String customCatalog() {
        return "customCatalog";
    }
    @GetMapping("/sportCatalog")
    public String sportCatalog() {
        return "sportCatalog";
    }
    @GetMapping("/order")
    public String finalOrder() {
        return "finalOrder";
    }
    @GetMapping("/productDetail")
    public String productDetail() {
        return "productDetail";
    }
    @GetMapping("/shoppingCart")
    public String shoppingCart() {
        return "shoppingCart";
    }
}
