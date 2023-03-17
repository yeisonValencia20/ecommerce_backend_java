package com.curso.ecommerce.springecommerce.model;

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    private int cantidad;

    public Producto() {

    }

    public Producto(Integer id, String nombre, String descripcion, String imagen, double precio, int cantidad) {
        this.id          = id;
        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.imagen      = imagen;
        this.precio      = precio;
        this.cantidad    = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", precio=" + precio + ", cantidad="+ cantidad + "]";
    }
}
