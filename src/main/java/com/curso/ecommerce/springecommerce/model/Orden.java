package com.curso.ecommerce.springecommerce.model;

import java.util.Date;

public class Orden {
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;

    public Orden() {

    }

    public Orden(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, double total) {
        this.id            = id;
        this.numero        = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total         = total;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public Integer getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public double getTotal() {
        return total;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
