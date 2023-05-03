package com.curso.ecommerce.springecommerce.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.ecommerce.springecommerce.model.DetalleOrden;
import com.curso.ecommerce.springecommerce.model.Orden;
import com.curso.ecommerce.springecommerce.model.Producto;
import com.curso.ecommerce.springecommerce.model.Usuario;
import com.curso.ecommerce.springecommerce.service.DetalleOrdenService;
import com.curso.ecommerce.springecommerce.service.OrdenService;
import com.curso.ecommerce.springecommerce.service.ProductoService;
import com.curso.ecommerce.springecommerce.service.UsuarioService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OrdenService ordenService;

    @Autowired
    private DetalleOrdenService detalleOrdenService;

    // para almacenar los detalles de la orden
    private List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    // los datos de la orden
    private Orden orden = new Orden();
    
    @GetMapping("")
    public String home(Model model, HttpSession session) {
        log.info("Id session usuario {}", session.getAttribute("idusuario"));

        model.addAttribute("productos", productoService.findAll());
        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String verProducto(@PathVariable Integer id, Model model) {
        log.info("id producto enviado como parametro {}", id);
        Producto producto = productoService.get(id).get();

        model.addAttribute("producto", producto);
        return "usuario/productoHome";
    }

    @PostMapping("cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {

        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = productoService.get(id).get();
        double sumaTotal = 0;
        log.info("Producto agregado: {}", producto);
        log.info("Cantidad: {}", cantidad);
        
        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio() * cantidad);
        detalleOrden.setProducto(producto);

        // TODO:validar que mas adelante, si se agregar un producto que ya esta en el carrito de compras, aumentar el numero de la orden
        detalles.add(detalleOrden);

        sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("delete/cart/{id}")
    public String deleteProductCart(@PathVariable Integer id, Model model) {

        List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

        for (DetalleOrden detalleOrden: detalles) {
            if (detalleOrden.getProducto().getId() != id) {
                ordenesNueva.add(detalleOrden);
            }
        }

        detalles = ordenesNueva;

        double sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("listCart")
    public String listCart(Model model) {
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        return "usuario/carrito";
    }

    @GetMapping("order")
    public String order(Model model, HttpSession session) {

        int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
        Usuario usuario = usuarioService.findById(idUsuario).get();

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        model.addAttribute("usuario", usuario);
        return "usuario/resumenorden";
    }

    @GetMapping("saveOrder")
    public String saveOrder(HttpSession session) {

        // fecha de creacion de la orden
        Date fecha = new Date();
        orden.setFechaCreacion(fecha);

        int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
        Usuario usuario = usuarioService.findById(idUsuario).get();
        orden.setUsuario(usuario);

        // generar numero de la orden
        orden.setNumero(ordenService.generarNumeroOrden());

        ordenService.save(orden);

        for (DetalleOrden dt:detalles) {
            dt.setOrden(orden);
            log.info("{}", dt);
            detalleOrdenService.save(dt);
        }

        orden = new Orden();
        detalles.clear();
        
        return "redirect:/";
    }

    @PostMapping("search")
    public String buscarProducto(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto: {}", nombre);
        List<Producto> productos = productoService.findAll().stream().filter(p -> p.getNombre().contains(nombre)).toList();
        model.addAttribute("productos", productos);
        
        return "usuario/home";
    }
}
