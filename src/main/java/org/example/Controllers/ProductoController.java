package org.example.Controllers;

import org.example.Models.Producto;
import org.example.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class ProductoController {
    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping(path = "listProductos")
    public String getAllProductos(Model model) {
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "Producto";
    }

    @PostMapping(path = "addProducto")
    public String addNuevoProducto(Producto producto, Model model) {
        productoRepository.save(producto);
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "Productos";
    }
}
