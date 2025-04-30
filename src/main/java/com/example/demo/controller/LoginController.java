package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Login;
import com.example.demo.model.LoginDTO;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    // @PostMapping
    // public ResponseEntity<String> validarLogin(@RequestBody Login login){
    //     Login bdd = loginService.validarLogin(login);
    //     if(bdd.getId_login() != null){
    //         return ResponseEntity.ok("El usuario es: " + loginService.obtenerNombre(bdd.getId_login()));
    //     }
    //     return ResponseEntity.ok("¿Quien soi vo loco?");
       
    // }

    @PostMapping
    public ResponseEntity<String> validarLogin(@RequestBody Login loign){
        LoginDTO DB = loginService.validarLogin(loign);
        if(DB != null){
            return ResponseEntity.ok("El usuario es: "+ DB.getNombreUsuario());
        }
        return ResponseEntity.ok("¿Quien soy vo loco?");
    }

}
