/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.dao;

import java.util.List;
import mx.edu.uteq.solicitapp.model.entity.Profesor;
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
public interface IProfesor extends JpaRepository<Profesor, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO profesor(id_cubi, id_usua) VALUES(?1, ?2)", nativeQuery = true)
    void save(String idCubi, String idUsua);
    
    @Transactional
    @Query(value = "SELECT MAX(id_prof) FROM profesor", nativeQuery = true)
    String getLastId();
}
