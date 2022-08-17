/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.dao.ISolicitud;
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
public class SolicitudServiceImp implements ISolicitudService{
    @Autowired
    private ISolicitud solicitudDao;
    
    @Override
    @Transactional
    public String getLastId() {
        return solicitudDao.getLastId();
    }
    
    @Override
    @Transactional
    public void insert(String idProf, String nomAlumnSoli, String matAlumnSoli, String asuntoSoli) {
        solicitudDao.save(idProf, nomAlumnSoli, matAlumnSoli, asuntoSoli);
    }

    @Override
    @Transactional(readOnly = true)
    public Solicitud findById(Solicitud solicitud) {
        return solicitudDao.findById(solicitud.getIdSoli()).orElse(null);
    }
    
}
