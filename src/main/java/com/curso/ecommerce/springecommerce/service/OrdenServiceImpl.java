package com.curso.ecommerce.springecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.springecommerce.model.Orden;
import com.curso.ecommerce.springecommerce.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService{

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public Orden save(Orden orden) {
       return ordenRepository.save(orden);
    }

    @Override
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }
    
    public String generarNumeroOrden() {
        int numero = 0;
        List<Orden> ordenes = findAll();

        List<Integer> numeros = new ArrayList<Integer>();

        ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));

        if (ordenes.isEmpty()) {
            numero = 1;
        }
        else {
            numero = numeros.stream().max(Integer::compare).get();
            numero++;
        }

        return concatenarNumero(numero);
    }

    public String concatenarNumero(Integer numero) {
        String numeroString = Integer.toString(numero);

        String zero = "0";
        String zeros = zero.repeat(10 - numeroString.length());

        return zeros + numeroString;
    }
}
