package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Paciente;



import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // @Query("select p from Paciente p where p.apellidos= :apellidos")
    // List<Paciente> buscarPorApellido(@Param("apellidos") String apellidos);

    // @Query("select p from Paciente p where p.correo= :correo")
    // List<Paciente> buscarPorCorreo(@Param("correo") String correo);

}