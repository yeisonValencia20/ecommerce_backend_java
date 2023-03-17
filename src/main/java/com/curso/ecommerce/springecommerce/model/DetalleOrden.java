package com.curso.ecommerce.springecommerce.model;

public class DetalleOrden {
    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

    public DetalleOrden() {

    }

    public DetalleOrden(Integer id, String nombre, double cantidad, double precio, double total) {
        this.id = id; 
        this.nombre = nombre; 
        this.cantidad = cantidad; 
        this.precio = precio; 
        this.total = total; 
    }

    public double getCantidad() {
        return cantidad;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTotal() {
        return total;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
