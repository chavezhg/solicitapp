/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.dao.IProfesor;
import mx.edu.uteq.solicitapp.dao.IUsuario;
import mx.edu.uteq.solicitapp.model.entity.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo
 */
@Service
public class ProfesorServiceImp implements IProfesorService{
    @Autowired
    private IProfesor profesorDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Profesor> getAll() {
        return (List<Profesor>) profesorDao.findAll();
    }
    
    @Override
    @Transactional
    public String getLastId() {
        return profesorDao.getLastId();
    }

    @Override
    @Transactional
    public void delete(Profesor profesor) {
        profesorDao.delete(profesor);
    }
    
    @Override
    @Transactional
    public void insert(String idCubi, String idUsua) {
        profesorDao.save(idCubi, idUsua);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findById(Profesor profesor) {
        return profesorDao.findById(profesor.getIdProf()).orElse(null);
    }
    
}
