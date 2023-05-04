package com.curso.ecommerce.springecommerce.service;

import java.util.List;

import com.curso.ecommerce.springecommerce.model.Orden;
import com.curso.ecommerce.springecommerce.model.Usuario;

public interface OrdenService {

    public Orden save(Orden orden);

    public List<Orden> findAll();

    public String generarNumeroOrden();

    public List<Orden> findByUsuario(Usuario usuario);
}
