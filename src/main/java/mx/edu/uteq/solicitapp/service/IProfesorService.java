/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.model.entity.Profesor;
import mx.edu.uteq.solicitapp.model.entity.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IProfesorService {
    public List<Profesor> getAll();
    public String getLastId();
    public void delete(Profesor profesor);
    public void insert(String idCubi, String idUsua);
    public Profesor findById(Profesor profesor);
}
