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
import javax.validation.constraints.Size;

/**
 *
 * @author Raul
 */
@Embeddable
public class AutomotorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "noSerieAutomotor")
    private String noSerieAutomotor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Usuario_nombreUsuario")
    private String usuarionombreUsuario;

    public AutomotorPK() {
    }

    public AutomotorPK(String noSerieAutomotor, String usuarionombreUsuario) {
        this.noSerieAutomotor = noSerieAutomotor;
        this.usuarionombreUsuario = usuarionombreUsuario;
    }

    public String getNoSerieAutomotor() {
        return noSerieAutomotor;
    }

    public void setNoSerieAutomotor(String noSerieAutomotor) {
        this.noSerieAutomotor = noSerieAutomotor;
    }

    public String getUsuarionombreUsuario() {
        return usuarionombreUsuario;
    }

    public void setUsuarionombreUsuario(String usuarionombreUsuario) {
        this.usuarionombreUsuario = usuarionombreUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noSerieAutomotor != null ? noSerieAutomotor.hashCode() : 0);
        hash += (usuarionombreUsuario != null ? usuarionombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutomotorPK)) {
            return false;
        }
        AutomotorPK other = (AutomotorPK) object;
        if ((this.noSerieAutomotor == null && other.noSerieAutomotor != null) || (this.noSerieAutomotor != null && !this.noSerieAutomotor.equals(other.noSerieAutomotor))) {
            return false;
        }
        if ((this.usuarionombreUsuario == null && other.usuarionombreUsuario != null) || (this.usuarionombreUsuario != null && !this.usuarionombreUsuario.equals(other.usuarionombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.AutomotorPK[ noSerieAutomotor=" + noSerieAutomotor + ", usuarionombreUsuario=" + usuarionombreUsuario + " ]";
    }
    
}
