package org.example.repository;

import org.example.Logic.Logic;
import org.example.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepository {
    private final Logic logic;

    @Autowired
    public ProductoRepository(Logic logic) {
        this.logic = logic;
    }
    public List<Producto> findAll() {
        return logic.getListaProductos();
    }

    public void save(Producto nUsuario) {
        logic.salvarProducto(nUsuario);
    }
}
