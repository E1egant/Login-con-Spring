package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{usuario}")
    public ResponseEntity<?> buscarUsuario(@PathVariable String usuario) {
        Usuario encontrado = usuarioService.buscarPorUsuario(usuario);
        if (encontrado == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado");
    }

    return ResponseEntity.ok(encontrado);
}
    
    @PostMapping("{agregar}")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
        return ResponseEntity.ok("Usuario agregado/actualizado");
    
    }

    @DeleteMapping("{borrar}")
    public ResponseEntity<String> eliminarUsuario(@RequestBody Usuario usuario){

        usuarioService.delete(usuario.getId_usuario());
        return ResponseEntity.ok("Usuario eliminado");

    }

}