/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimovil.rest;

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
@Table(name = "Version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v"),
    @NamedQuery(name = "Version.findByIdVersion", query = "SELECT v FROM Version v WHERE v.versionPK.idVersion = :idVersion"),
    @NamedQuery(name = "Version.findByNomVersion", query = "SELECT v FROM Version v WHERE v.nomVersion = :nomVersion"),
    @NamedQuery(name = "Version.findByTipoMotor", query = "SELECT v FROM Version v WHERE v.tipoMotor = :tipoMotor"),
    @NamedQuery(name = "Version.findByAnioidAnio", query = "SELECT v FROM Version v WHERE v.versionPK.anioidAnio = :anioidAnio"),
    @NamedQuery(name = "Version.findByAnioModeloidModelo", query = "SELECT v FROM Version v WHERE v.versionPK.anioModeloidModelo = :anioModeloidModelo"),
    @NamedQuery(name = "Version.findByAnioModeloMarcaidMarca", query = "SELECT v FROM Version v WHERE v.versionPK.anioModeloMarcaidMarca = :anioModeloMarcaidMarca")})
public class Version implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VersionPK versionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomVersion")
    private String nomVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoMotor")
    private String tipoMotor;
    @JoinColumns({
        @JoinColumn(name = "Anio_idAnio", referencedColumnName = "idAnio", insertable = false, updatable = false),
        @JoinColumn(name = "Anio_Modelo_idModelo", referencedColumnName = "Modelo_idModelo", insertable = false, updatable = false),
        @JoinColumn(name = "Anio_Modelo_Marca_idMarca", referencedColumnName = "Modelo_Marca_idMarca", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Anio anio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "version")
    private List<Automotor> automotorList;

    public Version() {
    }

    public Version(VersionPK versionPK) {
        this.versionPK = versionPK;
    }

    public Version(VersionPK versionPK, String nomVersion, String tipoMotor) {
        this.versionPK = versionPK;
        this.nomVersion = nomVersion;
        this.tipoMotor = tipoMotor;
    }

    public Version(int idVersion, int anioidAnio, int anioModeloidModelo, int anioModeloMarcaidMarca) {
        this.versionPK = new VersionPK(idVersion, anioidAnio, anioModeloidModelo, anioModeloMarcaidMarca);
    }

    public VersionPK getVersionPK() {
        return versionPK;
    }

    public void setVersionPK(VersionPK versionPK) {
        this.versionPK = versionPK;
    }

    public String getNomVersion() {
        return nomVersion;
    }

    public void setNomVersion(String nomVersion) {
        this.nomVersion = nomVersion;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public Anio getAnio() {
        return anio;
    }

    public void setAnio(Anio anio) {
        this.anio = anio;
    }

    @XmlTransient
    public List<Automotor> getAutomotorList() {
        return automotorList;
    }

    public void setAutomotorList(List<Automotor> automotorList) {
        this.automotorList = automotorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (versionPK != null ? versionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.versionPK == null && other.versionPK != null) || (this.versionPK != null && !this.versionPK.equals(other.versionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.Version[ versionPK=" + versionPK + " ]";
    }
    
}
