package br.com.abimael.app_auth_youtube.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    public String list() {
        return "listando produtos";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public String create() {
        return "cadastrando produtos";
    }
}
