package org.example.repository;

import org.example.Logic.Logic;
import org.example.Models.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacturaRepository {
    private final Logic logic;

    @Autowired
    public FacturaRepository(Logic logic) {
        this.logic= logic;

    }
    public List<Factura> findAll() {
        return logic.getListaFacturas();
    }

    public void save(Factura nUsuario) {
        logic.salvarFactura(nUsuario);
    }
}
