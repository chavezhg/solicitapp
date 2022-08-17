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
public interface ISolicitud extends JpaRepository<Solicitud, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO solicitud(id_prof, nom_alumn_soli, mat_alumn_soli, asunto_soli) VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
    void save(String idProf, String nomAlumnSoli, String matAlumnSoli, String asuntoSoli);
    
    @Transactional
    @Query(value = "SELECT MAX(id_soli) FROM solicitud", nativeQuery = true)
    String getLastId();
    
    @Transactional
    @Query(value = "SELECT * FROM turno INNER JOIN solicitud ON solicitud.id_soli = turno.id_soli WHERE id_prof = ?1", nativeQuery = true)
    List<Turno> findByIdUsua(String idUsua);
}
