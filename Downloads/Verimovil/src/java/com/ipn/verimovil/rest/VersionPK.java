/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimovil.rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Raul
 */
@Embeddable
public class VersionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idVersion")
    private int idVersion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anio_idAnio")
    private int anioidAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anio_Modelo_idModelo")
    private int anioModeloidModelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anio_Modelo_Marca_idMarca")
    private int anioModeloMarcaidMarca;

    public VersionPK() {
    }

    public VersionPK(int idVersion, int anioidAnio, int anioModeloidModelo, int anioModeloMarcaidMarca) {
        this.idVersion = idVersion;
        this.anioidAnio = anioidAnio;
        this.anioModeloidModelo = anioModeloidModelo;
        this.anioModeloMarcaidMarca = anioModeloMarcaidMarca;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public int getAnioidAnio() {
        return anioidAnio;
    }

    public void setAnioidAnio(int anioidAnio) {
        this.anioidAnio = anioidAnio;
    }

    public int getAnioModeloidModelo() {
        return anioModeloidModelo;
    }

    public void setAnioModeloidModelo(int anioModeloidModelo) {
        this.anioModeloidModelo = anioModeloidModelo;
    }

    public int getAnioModeloMarcaidMarca() {
        return anioModeloMarcaidMarca;
    }

    public void setAnioModeloMarcaidMarca(int anioModeloMarcaidMarca) {
        this.anioModeloMarcaidMarca = anioModeloMarcaidMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVersion;
        hash += (int) anioidAnio;
        hash += (int) anioModeloidModelo;
        hash += (int) anioModeloMarcaidMarca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionPK)) {
            return false;
        }
        VersionPK other = (VersionPK) object;
        if (this.idVersion != other.idVersion) {
            return false;
        }
        if (this.anioidAnio != other.anioidAnio) {
            return false;
        }
        if (this.anioModeloidModelo != other.anioModeloidModelo) {
            return false;
        }
        if (this.anioModeloMarcaidMarca != other.anioModeloMarcaidMarca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.VersionPK[ idVersion=" + idVersion + ", anioidAnio=" + anioidAnio + ", anioModeloidModelo=" + anioModeloidModelo + ", anioModeloMarcaidMarca=" + anioModeloMarcaidMarca + " ]";
    }
    
}
