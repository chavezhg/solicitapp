package mx.edu.uteq.solicitapp.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Ricardo
 */
@Data
public class RequestSolicitud implements Serializable {
    public String idProf;
    
    public String nomAlumnSoli;

    public String matAlumnSoli;

    public String asuntoSoli;
}