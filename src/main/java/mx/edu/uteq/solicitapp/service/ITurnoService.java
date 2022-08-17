/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.model.entity.Profesor;
import mx.edu.uteq.solicitapp.model.entity.Solicitud;
import mx.edu.uteq.solicitapp.model.entity.Turno;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricardo
 */
public interface ITurnoService {
    public String getLastId();
    public void insert(String idProf, String estaTurn);
    public void update(String idTurn, String estaTurn);
    public Turno findById(Turno turno);
    public List<Turno> findByIdUsua(String idUsua);
    public List<Turno> getAllAceptados();
    public List<Turno> findTurnosActualesByIdUsua(String idUsua);
}
