package me.dio.springsecurityjwt.controller;

import me.dio.springsecurityjwt.dto.Login;
import me.dio.springsecurityjwt.dto.Sessao;
import me.dio.springsecurityjwt.model.Usuario;
import me.dio.springsecurityjwt.repository.UsuarioRepository;
import me.dio.springsecurityjwt.security.JWTCreator;
import me.dio.springsecurityjwt.security.JWTObject;
import me.dio.springsecurityjwt.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login) {

        Usuario user = repository.findByUserName(login.getUsername());

        if (user != null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());

            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }

            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());

            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        } else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
