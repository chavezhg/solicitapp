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
@Table(name = "profesor")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idProf;
    @Column(name = "acti_prof", nullable = false)
    public String actiProf;
    @ManyToOne
    @JoinColumn(name = "id_cubi", nullable = false)
    public Cubiculo cubiculo;
    @ManyToOne
    @JoinColumn(name = "id_usua", nullable = false)
    public Usuario usuario;

}