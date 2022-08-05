package me.dio.springsecurityjwt.controller;

import me.dio.springsecurityjwt.model.Usuario;
import me.dio.springsecurityjwt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public void postUser(@RequestBody Usuario user) {
        service.createUser(user);
    }
}
