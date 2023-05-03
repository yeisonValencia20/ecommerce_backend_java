package com.curso.ecommerce.springecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

    @ManyToOne
    private Orden orden;

    @ManyToOne
    private Producto producto;

    public DetalleOrden() {

    }

    public DetalleOrden(Integer id, String nombre, double cantidad, double precio, double total, Orden orden, Producto producto) {
        this.id       = id; 
        this.nombre   = nombre; 
        this.cantidad = cantidad; 
        this.precio   = precio; 
        this.total    = total; 
        this.orden    = orden;
        this.producto  = producto;
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

    public Orden getOrden() {
        return orden;
    }

    public Producto getProducto() {
        return producto;
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

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
