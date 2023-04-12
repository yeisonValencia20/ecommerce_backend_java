package com.curso.ecommerce.springecommerce.service;

import java.util.List;

import com.curso.ecommerce.springecommerce.model.Orden;

public interface OrdenService {

    public Orden save(Orden orden);

    public List<Orden> findAll();

    public String generarNumeroOrden();
}
