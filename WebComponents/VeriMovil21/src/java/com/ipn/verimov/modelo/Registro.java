/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raul
 */
@Entity
@Table(name = "Registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdRegistro", query = "SELECT r FROM Registro r WHERE r.idRegistro = :idRegistro"),
    @NamedQuery(name = "Registro.findByValorCO2Vol", query = "SELECT r FROM Registro r WHERE r.valorCO2Vol = :valorCO2Vol"),
    @NamedQuery(name = "Registro.findByValorCOVol", query = "SELECT r FROM Registro r WHERE r.valorCOVol = :valorCOVol"),
    @NamedQuery(name = "Registro.findByAceptado", query = "SELECT r FROM Registro r WHERE r.aceptado = :aceptado")})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRegistro")
    private Integer idRegistro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "ValorCO2ppm")
    private String valorCO2ppm;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "ValorCOppm")
    private String valorCOppm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorCO2Vol")
    private double valorCO2Vol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorCOVol")
    private double valorCOVol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Aceptado")
    private boolean aceptado;
    @JoinColumns({
        @JoinColumn(name = "Automotor_noSerieAutomotor", referencedColumnName = "noSerieAutomotor"),
        @JoinColumn(name = "Automotor_Usuario_nombreUsuario", referencedColumnName = "Usuario_nombreUsuario")})
    @ManyToOne(optional = false)
    private Automotor automotor;

    public Registro() {
    }

    public Registro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Registro(Integer idRegistro, String valorCO2ppm, String valorCOppm, double valorCO2Vol, double valorCOVol, boolean aceptado) {
        this.idRegistro = idRegistro;
        this.valorCO2ppm = valorCO2ppm;
        this.valorCOppm = valorCOppm;
        this.valorCO2Vol = valorCO2Vol;
        this.valorCOVol = valorCOVol;
        this.aceptado = aceptado;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getValorCO2ppm() {
        return valorCO2ppm;
    }

    public void setValorCO2ppm(String valorCO2ppm) {
        this.valorCO2ppm = valorCO2ppm;
    }

    public String getValorCOppm() {
        return valorCOppm;
    }

    public void setValorCOppm(String valorCOppm) {
        this.valorCOppm = valorCOppm;
    }

    public double getValorCO2Vol() {
        return valorCO2Vol;
    }

    public void setValorCO2Vol(double valorCO2Vol) {
        this.valorCO2Vol = valorCO2Vol;
    }

    public double getValorCOVol() {
        return valorCOVol;
    }

    public void setValorCOVol(double valorCOVol) {
        this.valorCOVol = valorCOVol;
    }

    public boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Automotor getAutomotor() {
        return automotor;
    }

    public void setAutomotor(Automotor automotor) {
        this.automotor = automotor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipn.verimov.modelo.Registro[ idRegistro=" + idRegistro + " ]";
    }
    
}
