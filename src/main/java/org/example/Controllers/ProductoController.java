package org.example.Controllers;

import org.example.Models.Producto;
import org.example.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return (List<Producto>) productoRepository.findAll();

    }

    @PostMapping
    public void addNuevoProducto(@RequestBody Producto producto) {
        productoRepository.save(producto);
    }
}
