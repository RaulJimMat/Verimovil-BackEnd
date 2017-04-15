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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raul
 */
@Entity
@Table(name = "Anio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anio.findAll", query = "SELECT a FROM Anio a"),
    @NamedQuery(name = "Anio.findByIdAnio", query = "SELECT a FROM Anio a WHERE a.anioPK.idAnio = :idAnio"),
    @NamedQuery(name = "Anio.findByNumAnio", query = "SELECT a FROM Anio a WHERE a.numAnio = :numAnio"),
    @NamedQuery(name = "Anio.findByModeloidModelo", query = "SELECT a FROM Anio a WHERE a.anioPK.modeloidModelo = :modeloidModelo"),
    @NamedQuery(name = "Anio.findByModeloMarcaidMarca", query = "SELECT a FROM Anio a WHERE a.anioPK.modeloMarcaidMarca = :modeloMarcaidMarca")})
public class Anio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnioPK anioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numAnio")
    private int numAnio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anio")
    private List<Version> versionList;
    @JoinColumns({
        @JoinColumn(name = "Modelo_idModelo", referencedColumnName = "idModelo", insertable = false, updatable = false),
        @JoinColumn(name = "Modelo_Marca_idMarca", referencedColumnName = "Marca_idMarca", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Modelo modelo;

    public Anio() {
    }

    public Anio(AnioPK anioPK) {
        this.anioPK = anioPK;
    }

    public Anio(AnioPK anioPK, int numAnio) {
        this.anioPK = anioPK;
        this.numAnio = numAnio;
    }

    public Anio(int idAnio, int modeloidModelo, int modeloMarcaidMarca) {
        this.anioPK = new AnioPK(idAnio, modeloidModelo, modeloMarcaidMarca);
    }

    public AnioPK getAnioPK() {
        return anioPK;
    }

    public void setAnioPK(AnioPK anioPK) {
        this.anioPK = anioPK;
    }

    public int getNumAnio() {
        return numAnio;
    }

    public void setNumAnio(int numAnio) {
        this.numAnio = numAnio;
    }

    @XmlTransient
    public List<Version> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<Version> versionList) {
        this.versionList = versionList;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anioPK != null ? anioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anio)) {
            return false;
        }
        Anio other = (Anio) object;
        if ((this.anioPK == null && other.anioPK != null) || (this.anioPK != null && !this.anioPK.equals(other.anioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.Anio[ anioPK=" + anioPK + " ]";
    }
    
}
