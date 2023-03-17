package com.curso.ecommerce.springecommerce.model;

public class Usuario {
    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;

    public Usuario(){

    }

    public Usuario(Integer id, String nombre, String username, String email, String direccion, String telefono, String tipo, String password){
        this.id        = id;
        this.nombre    = nombre;
        this.username  = username;
        this.email     = email;
        this.direccion = direccion;
        this.telefono  = telefono;
        this.tipo      = tipo;
        this.password  = password;
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

    @Override
    public String toString() {
        return "Usuario [id="+ id + ", nombre="+ nombre + ", username="+ username + ", email="+ email + ", direccion="+ direccion + ", telefono="+ telefono + ", tipo="+ tipo + ", password=" + password + "]";
    }
}
