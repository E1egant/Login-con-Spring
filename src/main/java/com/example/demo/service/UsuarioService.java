package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }


    public Usuario buscarPorUsuario(String usuario){
       return usuarioRepository.buscarPorUsuario(usuario);
    }

    public Usuario findById(long id){
        return usuarioRepository.findById(id).get();
    }

    public Usuario save(Usuario usuario){
        String passwordEncriptada = passwordEncoder.encode(usuario.login.getContraseña());
        usuario.login.setContraseña(passwordEncriptada);
        return usuarioRepository.save(usuario);
    }

    public void delete(long id){

        usuarioRepository.deleteById(id);
    }

}
