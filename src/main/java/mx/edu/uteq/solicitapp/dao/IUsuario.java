/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.dao;

import java.util.List;
import mx.edu.uteq.solicitapp.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo
 */
@Repository
public interface IUsuario extends JpaRepository<Usuario, Long> {

    public Usuario findByCorreoUsua(String correoUsua);
    
    @Transactional
    @Query(value = "SELECT * FROM usuario WHERE correo_usua = ?1", nativeQuery = true)
    Usuario findUsuaByEmail(String correoUsua);
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usuario(nomb_usua, correo_usua, contra_usua) VALUES(?1, ?2, ?3)", nativeQuery = true)
    void save(String nombUsua, String correoUsua, String contraUsua);
    
    @Transactional
    @Query(value = "SELECT MAX(id_usua) FROM usuario", nativeQuery = true)
    String getLastId();
}
