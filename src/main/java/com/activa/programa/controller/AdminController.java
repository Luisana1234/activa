package com.activa.programa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {


    @GetMapping("api/admin")
    public String home() {
        System.out.println("Entra");
        return "admin/adminTable";
    }


}