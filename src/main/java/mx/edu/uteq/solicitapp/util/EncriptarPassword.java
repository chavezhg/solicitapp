/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.solicitapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author Ricardo
 */
public class EncriptarPassword {
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
}

