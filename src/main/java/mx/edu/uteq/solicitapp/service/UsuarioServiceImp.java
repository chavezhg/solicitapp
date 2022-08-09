/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.List;
import mx.edu.uteq.solicitapp.dao.IUsuario;
import mx.edu.uteq.solicitapp.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo
 */
@Service
public class UsuarioServiceImp implements IUsuarioService{
    @Autowired
    private IUsuario usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }
    
    @Override
    @Transactional
    public String getLastId() {
        return usuarioDao.getLastId();
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
    @Override
    @Transactional
    public void insert(String nombUsua, String correoUsua, String contraUsua) {
        usuarioDao.save(nombUsua, correoUsua, contraUsua);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsua()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findByCorreoUsua(String email){
        return usuarioDao.findByCorreoUsua(email);
    }
    
}
