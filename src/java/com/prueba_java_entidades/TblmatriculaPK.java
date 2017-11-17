/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba_java_entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Flia Ponce Verjel
 */
@Embeddable
public class TblmatriculaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estudiantes_id")
    private int estudiantesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cursos_id")
    private int cursosId;

    public TblmatriculaPK() {
    }

    public TblmatriculaPK(int id, int estudiantesId, int cursosId) {
        this.id = id;
        this.estudiantesId = estudiantesId;
        this.cursosId = cursosId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudiantesId() {
        return estudiantesId;
    }

    public void setEstudiantesId(int estudiantesId) {
        this.estudiantesId = estudiantesId;
    }

    public int getCursosId() {
        return cursosId;
    }

    public void setCursosId(int cursosId) {
        this.cursosId = cursosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) estudiantesId;
        hash += (int) cursosId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblmatriculaPK)) {
            return false;
        }
        TblmatriculaPK other = (TblmatriculaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.estudiantesId != other.estudiantesId) {
            return false;
        }
        if (this.cursosId != other.cursosId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba_java_servlet.TblmatriculaPK[ id=" + id + ", estudiantesId=" + estudiantesId + ", cursosId=" + cursosId + " ]";
    }
    
}
