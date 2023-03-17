package com.curso.ecommerce.springecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;

    public Usuario(){

    }

    public Usuario(Integer id, String nombre, String username, String email, String direccion, String telefono, String tipo, String password, List<Producto> productos, List<Orden> ordenes){
        this.id        = id;
        this.nombre    = nombre;
        this.username  = username;
        this.email     = email;
        this.direccion = direccion;
        this.telefono  = telefono;
        this.tipo      = tipo;
        this.password  = password;
        this.productos = productos;
        this.ordenes   = ordenes; 
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUsername() {
        return username;
    }

    public List<Producto> getProducto() {
        return productos;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProducto(List<Producto> producto) {
        this.productos = producto;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return "Usuario [id="+ id + ", nombre="+ nombre + ", username="+ username + ", email="+ email + ", direccion="+ direccion + ", telefono="+ telefono + ", tipo="+ tipo + ", password=" + password + "]";
    }
}
