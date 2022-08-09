/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.service;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.edu.uteq.solicitapp.dao.IUsuario;
import mx.edu.uteq.solicitapp.model.entity.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



/**
 *
 * @author Ricardo
 */
@Service
@Slf4j
public class UsuarioService implements UserDetailsService{
    @Autowired
    private IUsuario interfazUsuario;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correoUsua) throws UsernameNotFoundException{
        Usuario usuario = interfazUsuario.findByCorreoUsua(correoUsua);
        if (usuario==null){
            throw new UsernameNotFoundException(correoUsua);
        }
        User user = new User(usuario.getCorreoUsua(), usuario.getContraUsua(), new ArrayList<>());
        return user;
    }
    
    @Transactional(readOnly = true)
    public Usuario findByCorreoUsua(String email){
        return interfazUsuario.findByCorreoUsua(email);
    }
}
