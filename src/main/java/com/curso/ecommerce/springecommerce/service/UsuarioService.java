package com.curso.ecommerce.springecommerce.service;

import java.util.Optional;

import com.curso.ecommerce.springecommerce.model.Usuario;

public interface UsuarioService {
    Optional<Usuario> findById(Integer id);
    void save(Usuario usuario);
    Optional<Usuario> findByEmail(String email);
}
