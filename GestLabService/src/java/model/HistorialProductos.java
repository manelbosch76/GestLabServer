/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "Historial_Productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialProductos.findAll", query = "SELECT h FROM HistorialProductos h"),
    @NamedQuery(name = "HistorialProductos.findById", query = "SELECT h FROM HistorialProductos h WHERE h.id = :id"),
    @NamedQuery(name = "HistorialProductos.findByFechaCompra", query = "SELECT h FROM HistorialProductos h WHERE h.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "HistorialProductos.findByCantidad", query = "SELECT h FROM HistorialProductos h WHERE h.cantidad = :cantidad")})
public class HistorialProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Compra")
    //@Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private float cantidad;
    @JoinColumn(name = "ID_Producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto iDProducto;
    @JoinColumn(name = "ID_Cliente", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Cliente iDCliente;

    public HistorialProductos() {
    }

    public HistorialProductos(Integer id) {
        this.id = id;
    }

    public HistorialProductos(Integer id, Date fechaCompra, float cantidad) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIDProducto() {
        return iDProducto;
    }

    public void setIDProducto(Producto iDProducto) {
        this.iDProducto = iDProducto;
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
        if (!(object instanceof HistorialProductos)) {
            return false;
        }
        HistorialProductos other = (HistorialProductos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.HistorialProductos[ id=" + id + " ]";
    }
    
}
