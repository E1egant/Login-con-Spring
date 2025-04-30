package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Login")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_login;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String contraseña;

    @OneToOne(mappedBy = "login")
    @JsonBackReference
    private Usuario usuario;


}