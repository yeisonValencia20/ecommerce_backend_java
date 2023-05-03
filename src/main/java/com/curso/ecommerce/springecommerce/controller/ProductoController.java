package com.curso.ecommerce.springecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.springecommerce.model.Producto;
import com.curso.ecommerce.springecommerce.model.Usuario;
import com.curso.ecommerce.springecommerce.service.ProductoService;
import com.curso.ecommerce.springecommerce.service.UploadFileService;
import com.curso.ecommerce.springecommerce.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();

        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto);
        return "productos/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Producto producto = productoService.get(id).get();

        // validar si la imagen que tiene el producto no es la imagen por defecto
        if (!producto.getImagen().equals("default.jpg")) {
            upload.deleteImage(producto.getImagen());
        }
        productoService.delete(id);
        return "redirect:/productos";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
        LOGGER.info("Este es el objeto producto {}", producto);

        Integer idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
        Usuario u = usuarioService.findById(idUsuario).get();
        producto.setUsuario(u);

        // Guardar imagen
        // cuando se crea un producto
        if (producto.getId() == null) {
            String fileName = upload.saveImage(file);
            producto.setImagen(fileName);
        }

        productoService.save(producto);
        return "redirect:/productos";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        Producto prevProducto = productoService.get(producto.getId()).get();

        if (file.isEmpty()) {
            producto.setImagen(prevProducto.getImagen());
        } else {
            if (!prevProducto.getImagen().equals("default.jpg")) {
                upload.deleteImage(prevProducto.getImagen());
            }

            String fileName = upload.saveImage(file);
            producto.setImagen(fileName);
        }

        producto.setUsuario(prevProducto.getUsuario());
        productoService.update(producto);
        return "redirect:/productos";
    }

}
