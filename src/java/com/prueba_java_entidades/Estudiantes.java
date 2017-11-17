/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba_java_entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Flia Ponce Verjel
 */
@Entity
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e")
    , @NamedQuery(name = "Estudiantes.findById", query = "SELECT e FROM Estudiantes e WHERE e.id = :id")
    , @NamedQuery(name = "Estudiantes.findByEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.estudiante = :estudiante")
    , @NamedQuery(name = "Estudiantes.findByCedulaTiPasaporte", query = "SELECT e FROM Estudiantes e WHERE e.cedulaTiPasaporte = :cedulaTiPasaporte")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "estudiante")
    private String estudiante;
    @Size(max = 20)
    @Column(name = "cedula_ti_pasaporte")
    private String cedulaTiPasaporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private List<Tblmatricula> tblmatriculaList;

    public Estudiantes() {
    }

    public Estudiantes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstudiante() {
        return estudiante;
    }
    
    public List<Estudiantes> getAllEstudiantes(){
        
       //EntityManager em = entityManagerFactory.createEntityManager();
      /*
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
       EntityManager em = (EntityManager) Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
*/
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager em = emf.createEntityManager();

        // EntityManager em
        Query query = em.createQuery("SELECT e FROM Estudiantes e");
        return (List<Estudiantes>) query.getResultList();
       // return null;
    
    
    }
    
    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getCedulaTiPasaporte() {
        return cedulaTiPasaporte;
    }

    public void setCedulaTiPasaporte(String cedulaTiPasaporte) {
        this.cedulaTiPasaporte = cedulaTiPasaporte;
    }

    @XmlTransient
    public List<Tblmatricula> getTblmatriculaList() {
        return tblmatriculaList;
    }

    public void setTblmatriculaList(List<Tblmatricula> tblmatriculaList) {
        this.tblmatriculaList = tblmatriculaList;
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
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba_java_servlet.Estudiantes[ id=" + id + " ]";
    }
    
}
