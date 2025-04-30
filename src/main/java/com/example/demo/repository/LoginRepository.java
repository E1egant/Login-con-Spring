package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Login;
import com.example.demo.model.LoginDTO;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    // @Query("select contraseña from Login l")
    // String buscarPorLogin(@Param("contraseña") String string);

    // @Query(value = "select nombre_usuario from Usuario u where u.login_id= :id_login", nativeQuery = true)
    // String obtenerNombreUsuario(@Param("id_login") Integer id_login);

    // @Query("select l from Login l")
    // Login buscarNombre(@Param("contraseña") String string);

    @Query("select new com.example.demo.model.LoginDTO(u.nombreUsuario, u.login.contraseña, u.login.email) from Usuario u where u.login.email=:email")
    LoginDTO validarLogin(@Param("email") String email);

}
 