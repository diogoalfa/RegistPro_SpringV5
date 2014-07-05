package com.springapp.mvc.models;

import javax.persistence.*;

/**
 * Created by macbookpro on 04-07-14.
 */
@Entity
@Table(name = "contacto", schema = "public", catalog = "ejemplo1")
public class ContactoEntity {


    @Id
    @Column(name = "id_contacto",nullable = false)
    @GeneratedValue(generator = "idseq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "idseq",sequenceName = "contacto_id_contacto_seq")
    private long id_contacto;
    public long getId_contacto(){
        return id_contacto;
    }

    private String nombre;
    private String correo;
    private String telefono;

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactoEntity that = (ContactoEntity) o;

        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        return result;
    }
}
