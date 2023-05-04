package com.curso.ecommerce.springecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.ecommerce.springecommerce.model.Orden;
import com.curso.ecommerce.springecommerce.model.Usuario;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{
    List<Orden> findByUsuario(Usuario usuario);
}
