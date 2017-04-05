/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manel
 */
@Entity
@Table(name = "Historial_Equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialEquipos.findAll", query = "SELECT h FROM HistorialEquipos h"),
    @NamedQuery(name = "HistorialEquipos.findById", query = "SELECT h FROM HistorialEquipos h WHERE h.id = :id"),
    @NamedQuery(name = "HistorialEquipos.findByInicioAlquiler", query = "SELECT h FROM HistorialEquipos h WHERE h.inicioAlquiler = :inicioAlquiler"),
    @NamedQuery(name = "HistorialEquipos.findByFinalAlquiler", query = "SELECT h FROM HistorialEquipos h WHERE h.finalAlquiler = :finalAlquiler")})
public class HistorialEquipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inicio_Alquiler")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioAlquiler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Final_Alquiler")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalAlquiler;
    @JoinColumn(name = "ID_Equipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipo iDEquipo;
    @JoinColumn(name = "ID_Cliente", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Cliente iDCliente;

    public HistorialEquipos() {
    }

    public HistorialEquipos(Integer id) {
        this.id = id;
    }

    public HistorialEquipos(Integer id, Date inicioAlquiler, Date finalAlquiler) {
        this.id = id;
        this.inicioAlquiler = inicioAlquiler;
        this.finalAlquiler = finalAlquiler;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicioAlquiler() {
        return inicioAlquiler;
    }

    public void setInicioAlquiler(Date inicioAlquiler) {
        this.inicioAlquiler = inicioAlquiler;
    }

    public Date getFinalAlquiler() {
        return finalAlquiler;
    }

    public void setFinalAlquiler(Date finalAlquiler) {
        this.finalAlquiler = finalAlquiler;
    }

    public Equipo getIDEquipo() {
        return iDEquipo;
    }

    public void setIDEquipo(Equipo iDEquipo) {
        this.iDEquipo = iDEquipo;
    }

    public Cliente getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Cliente iDCliente) {
        this.iDCliente = iDCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialEquipos)) {
            return false;
        }
        HistorialEquipos other = (HistorialEquipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.HistorialEquipos[ id=" + id + " ]";
    }
    
}
