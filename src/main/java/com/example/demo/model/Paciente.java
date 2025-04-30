package com.example.demo.model;


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
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_paciente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private int run;

    @Column(nullable = false)
    private int dv;

    @Column(nullable = true)
    private Date fecha_nac;

    @OneToOne(mappedBy = "paciente")
    @JsonBackReference
    private Usuario usuario;

}
