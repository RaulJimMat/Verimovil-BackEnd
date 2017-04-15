/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raul
 */
@Entity
@Table(name = "Modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m"),
    @NamedQuery(name = "Modelo.findByIdModelo", query = "SELECT m FROM Modelo m WHERE m.modeloPK.idModelo = :idModelo"),
    @NamedQuery(name = "Modelo.findByNombreModelo", query = "SELECT m FROM Modelo m WHERE m.nombreModelo = :nombreModelo"),
    @NamedQuery(name = "Modelo.findByMarcaidMarca", query = "SELECT m FROM Modelo m WHERE m.modeloPK.marcaidMarca = :marcaidMarca")})
public class Modelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModeloPK modeloPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreModelo")
    private String nombreModelo;
    @JoinColumn(name = "Marca_idMarca", referencedColumnName = "idMarca", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Marca marca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo")
    private List<Anio> anioList;

    public Modelo() {
    }

    public Modelo(ModeloPK modeloPK) {
        this.modeloPK = modeloPK;
    }

    public Modelo(ModeloPK modeloPK, String nombreModelo) {
        this.modeloPK = modeloPK;
        this.nombreModelo = nombreModelo;
    }

    public Modelo(int idModelo, int marcaidMarca) {
        this.modeloPK = new ModeloPK(idModelo, marcaidMarca);
    }

    public ModeloPK getModeloPK() {
        return modeloPK;
    }

    public void setModeloPK(ModeloPK modeloPK) {
        this.modeloPK = modeloPK;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @XmlTransient
    public List<Anio> getAnioList() {
        return anioList;
    }

    public void setAnioList(List<Anio> anioList) {
        this.anioList = anioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modeloPK != null ? modeloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.modeloPK == null && other.modeloPK != null) || (this.modeloPK != null && !this.modeloPK.equals(other.modeloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.Modelo[ modeloPK=" + modeloPK + " ]";
    }
    
}
