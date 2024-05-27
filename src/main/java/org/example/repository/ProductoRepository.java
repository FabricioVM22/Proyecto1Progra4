package org.example.repository;

import org.example.Logic.Logic;
import org.example.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepository {
    private List<Producto> productos;

    @Autowired
    public ProductoRepository(Logic logic) {
        this.productos = logic.getListaProductos();
    }
    public List<Producto> findAll() {
        return productos;
    }

    public void save(Producto nUsuario) {
        productos.add(nUsuario);
    }
}
