/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.dao.ISolicitud;
import mx.edu.uteq.solicitapp.dao.ITurno;
import mx.edu.uteq.solicitapp.model.entity.Solicitud;
import mx.edu.uteq.solicitapp.model.entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo
 */
@Service
public class TurnoServiceImp implements ITurnoService{
    @Autowired
    private ITurno turnoDao;
    
    @Override
    @Transactional
    public String getLastId() {
        return turnoDao.getLastId();
    }
    
    @Override
    @Transactional
    public void insert(String idSoli, String esta_turn) {
        turnoDao.save(idSoli, esta_turn);
    }
    
    @Override
    @Transactional
    public void update(String idTurn, String esta_turn) {
        turnoDao.update(idTurn, esta_turn);
    }

    @Override
    @Transactional(readOnly = true)
    public Turno findById(Turno turno) {
        return turnoDao.findById(turno.getIdTurn()).orElse(null);
    }
    
    @Override
    public List<Turno> findByIdUsua(String idUsua) {
        return turnoDao.findByIdUsua(idUsua);
    }
    
    @Override
    @Transactional
    public List<Turno> getAllAceptados(){
        return turnoDao.getAllAceptados();
    }
    
    @Override
    public List<Turno> findTurnosActualesByIdUsua(String idUsua) {
        return turnoDao.findTurnosActualesByIdUsua(idUsua);
    }
    
}
