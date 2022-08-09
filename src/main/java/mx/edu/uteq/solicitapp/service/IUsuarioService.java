/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.model.entity.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IUsuarioService {
    public List<Usuario> getAll();
    public String getLastId();
    public void delete(Usuario usuario);
    public void insert(String nombUsua, String correoUsua, String contraUsua);
    public Usuario findById(Usuario usuario);
    public Usuario findByCorreoUsua(String correoUsua);
}
