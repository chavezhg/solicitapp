/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.dao;

import java.util.List;
import mx.edu.uteq.solicitapp.model.entity.Solicitud;
import mx.edu.uteq.solicitapp.model.entity.Turno;
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
public interface ITurno extends JpaRepository<Turno, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO turno(id_soli, esta_turn) VALUES(?1, ?2)", nativeQuery = true)
    void save(String idSoli, String estaTurn);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE turno SET esta_turn = ?2 WHERE id_turn = ?1", nativeQuery = true)
    void update(String idTurn, String estaTurn);
    
    @Transactional
    @Query(value = "SELECT MAX(id_turn) FROM turno", nativeQuery = true)
    String getLastId();
    
    @Transactional
    @Query(value = "SELECT * FROM turno INNER JOIN solicitud ON solicitud.id_soli = turno.id_soli WHERE id_prof = ?1 AND esta_turn = 'Pendiente'", nativeQuery = true)
    List<Turno> findByIdUsua(String idUsua);
    
    @Transactional
    @Query(value = "SELECT * FROM turno INNER JOIN solicitud ON solicitud.id_soli = turno.id_soli WHERE esta_turn = 'Aceptado'", nativeQuery = true)
    List<Turno> getAllAceptados();
    
    @Transactional
    @Query(value = "SELECT * FROM turno INNER JOIN solicitud ON solicitud.id_soli = turno.id_soli WHERE id_prof = ?1 AND esta_turn = 'Aceptado'", nativeQuery = true)
    List<Turno> findTurnosActualesByIdUsua(String idUsua);
}
