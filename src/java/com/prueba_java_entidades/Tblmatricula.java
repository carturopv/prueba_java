/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba_java_entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Flia Ponce Verjel
 */
@Entity
@Table(name = "tblmatricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblmatricula.findAll", query = "SELECT t FROM Tblmatricula t")
    , @NamedQuery(name = "Tblmatricula.findById", query = "SELECT t FROM Tblmatricula t WHERE t.tblmatriculaPK.id = :id")
    , @NamedQuery(name = "Tblmatricula.findByEstudiantesId", query = "SELECT t FROM Tblmatricula t WHERE t.tblmatriculaPK.estudiantesId = :estudiantesId")
    , @NamedQuery(name = "Tblmatricula.findByCursosId", query = "SELECT t FROM Tblmatricula t WHERE t.tblmatriculaPK.cursosId = :cursosId")
    , @NamedQuery(name = "Tblmatricula.findByCalificacion", query = "SELECT t FROM Tblmatricula t WHERE t.calificacion = :calificacion")})
public class Tblmatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblmatriculaPK tblmatriculaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion")
    private Float calificacion;
    @JoinColumn(name = "cursos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cursos cursos;
    @JoinColumn(name = "estudiantes_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;

    public Tblmatricula() {
    }

    public Tblmatricula(TblmatriculaPK tblmatriculaPK) {
        this.tblmatriculaPK = tblmatriculaPK;
    }

    public Tblmatricula(int id, int estudiantesId, int cursosId) {
        this.tblmatriculaPK = new TblmatriculaPK(id, estudiantesId, cursosId);
    }

    public TblmatriculaPK getTblmatriculaPK() {
        return tblmatriculaPK;
    }

    public void setTblmatriculaPK(TblmatriculaPK tblmatriculaPK) {
        this.tblmatriculaPK = tblmatriculaPK;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblmatriculaPK != null ? tblmatriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblmatricula)) {
            return false;
        }
        Tblmatricula other = (Tblmatricula) object;
        if ((this.tblmatriculaPK == null && other.tblmatriculaPK != null) || (this.tblmatriculaPK != null && !this.tblmatriculaPK.equals(other.tblmatriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba_java_servlet.Tblmatricula[ tblmatriculaPK=" + tblmatriculaPK + " ]";
    }
    
}
