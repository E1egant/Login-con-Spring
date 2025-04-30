package com.example.demo.repository;

import com.example.demo.model.Usuario;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Query("select u from Usuario u where u.nombreUsuario = :nombreUsuario")
    Usuario buscarPorUsuario(@Param("nombreUsuario") String usuario);

}
 