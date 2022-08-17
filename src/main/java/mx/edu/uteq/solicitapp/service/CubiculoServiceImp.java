/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.dao.ICubiculo;
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
public class CubiculoServiceImp implements ICubiculoService{
    @Autowired
    private ICubiculo cubiculoDao;
    
    @Override
    @Transactional
    public void insert(String codCubi, String dispCubi) {
        cubiculoDao.save(codCubi, dispCubi);
    }
    
    @Override
    @Transactional
    public String getLastId() {
        return cubiculoDao.getLastId();
    }
    
}
