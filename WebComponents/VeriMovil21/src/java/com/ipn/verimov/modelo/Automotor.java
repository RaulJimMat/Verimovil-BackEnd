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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raul
 */
@Entity
@Table(name = "Automotor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automotor.findAll", query = "SELECT a FROM Automotor a"),
    @NamedQuery(name = "Automotor.findByNoSerieAutomotor", query = "SELECT a FROM Automotor a WHERE a.automotorPK.noSerieAutomotor = :noSerieAutomotor"),
    @NamedQuery(name = "Automotor.findByTipoTransmision", query = "SELECT a FROM Automotor a WHERE a.tipoTransmision = :tipoTransmision"),
    @NamedQuery(name = "Automotor.findByUsuarionombreUsuario", query = "SELECT a FROM Automotor a WHERE a.automotorPK.usuarionombreUsuario = :usuarionombreUsuario")})
public class Automotor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutomotorPK automotorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoTransmision")
    private String tipoTransmision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "automotor")
    private List<Registro> registroList;
    @JoinColumn(name = "Usuario_nombreUsuario", referencedColumnName = "nombreUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumns({
        @JoinColumn(name = "Version_idVersion", referencedColumnName = "idVersion"),
        @JoinColumn(name = "Version_Anio_idAnio", referencedColumnName = "Anio_idAnio"),
        @JoinColumn(name = "Version_Anio_Modelo_idModelo", referencedColumnName = "Anio_Modelo_idModelo"),
        @JoinColumn(name = "Version_Anio_Modelo_Marca_idMarca", referencedColumnName = "Anio_Modelo_Marca_idMarca")})
    @ManyToOne(optional = false)
    private Version version;

    public Automotor() {
    }

    public Automotor(AutomotorPK automotorPK) {
        this.automotorPK = automotorPK;
    }

    public Automotor(AutomotorPK automotorPK, String tipoTransmision) {
        this.automotorPK = automotorPK;
        this.tipoTransmision = tipoTransmision;
    }

    public Automotor(String noSerieAutomotor, String usuarionombreUsuario) {
        this.automotorPK = new AutomotorPK(noSerieAutomotor, usuarionombreUsuario);
    }

    public AutomotorPK getAutomotorPK() {
        return automotorPK;
    }

    public void setAutomotorPK(AutomotorPK automotorPK) {
        this.automotorPK = automotorPK;
    }

    public String getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(String tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }

    @XmlTransient
    public List<Registro> getRegistroList() {
        return registroList;
    }

    public void setRegistroList(List<Registro> registroList) {
        this.registroList = registroList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (automotorPK != null ? automotorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automotor)) {
            return false;
        }
        Automotor other = (Automotor) object;
        if ((this.automotorPK == null && other.automotorPK != null) || (this.automotorPK != null && !this.automotorPK.equals(other.automotorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.Automotor[ automotorPK=" + automotorPK + " ]";
    }
    
}
