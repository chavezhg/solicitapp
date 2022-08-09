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
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idUsua;
    @Column(name = "nomb_usua", nullable = false)
    public String nombUsua;
    @Column(name = "correo_usua", nullable = false)
    public String correoUsua;
    @Column(name = "contra_usua", nullable = false)
    public String contraUsua;
    @Column(name = "tipo_usua", nullable = false)
    public String tipoUsua;

}