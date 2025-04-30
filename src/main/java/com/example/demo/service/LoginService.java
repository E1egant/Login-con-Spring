package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.Login;
import com.example.demo.model.LoginDTO;
import com.example.demo.repository.LoginRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;
    private PasswordEncoder passwordEncoder;

    public LoginService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    // public String buscarPorLogin(String login){
    //     return loginRepository.buscarPorLogin(login);
    // }

    public Login save(Login login){
        return loginRepository.save(login);
    }

    public void delete(Login login){
        loginRepository.delete(login);
    }

    // public void registrarContraseña(Login login){
    //     String passwordEncriptada = passwordEncoder.encode(login.getContraseña());
    //     login.setContraseña(passwordEncriptada);
    //     loginRepository.save(login);
    // }

    // public Boolean validarLogin(Login login){
    //     String tempContraseña = passwordEncoder.encode(login.getContraseña());
    //     String contrasela1 = loginRepository.buscarPorLogin(login.getContraseña());
    //     return passwordEncoder.matches(contrasela1,tempContraseña);   
    // }

    // public Login validarLogin(Login login){
    //     Login x = new Login();
    //     String tempContraseña = passwordEncoder.encode(login.getContraseña());
    //     Login contrasela1 = loginRepository.buscarNombre(login.getContraseña());
    //     passwordEncoder.matches(contrasela1.getContraseña(),tempContraseña);
    //     if(passwordEncoder.matches(contrasela1.getContraseña(),tempContraseña)){
    //         return contrasela1;
    //     }
    //     return x;
    // }

    // public String obtenerNombre(Integer login){
    //     return loginRepository.obtenerNombreUsuario(login);
    // }

    public LoginDTO validarLogin(Login login){
        LoginDTO contraseñaDB = loginRepository.validarLogin(login.getEmail());
        if(contraseñaDB != null && passwordEncoder.matches(login.getContraseña(), contraseñaDB.getContraseña())){
            return contraseñaDB;
        }
        return null;
    }

}