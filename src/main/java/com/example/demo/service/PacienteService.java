package com.example.demo.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.demo.model.Paciente;
// import com.example.demo.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PacienteService {
    
    // @Autowired
    // private PacienteRepository pacienteRepository;
    
    // public List<Paciente> findAll(){
    //     return pacienteRepository.findAll();
    // }

    // public List<Paciente> buscarPorApellido(String apellido){
    //     return pacienteRepository.buscarPorApellido(apellido);
    // }

    // public Paciente findById(long id){
    //     return pacienteRepository.findById(id).get();
    // }

    // public Paciente save(Paciente paciente){
    //     return pacienteRepository.save(paciente);
    // }

    // public void delete(Long id){
    //     pacienteRepository.deleteById(id);
    // }
}
