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
@Table(name = "solicitud")
public class Solicitud implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idSoli;
    @ManyToOne
    @JoinColumn(name = "id_prof", nullable = true)
    public Profesor profesor;
    @Column(name = "nom_alumn_soli", nullable = false)
    public String nomAlumnSoli;
    @Column(name = "mat_alumn_soli", nullable = false)
    public String matAlumnSoli;
    @Column(name = "asunto_soli", nullable = false)
    public String asuntoSoli;
}