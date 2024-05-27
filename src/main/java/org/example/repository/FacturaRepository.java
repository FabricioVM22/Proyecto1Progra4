package org.example.repository;

import org.example.Logic.Logic;
import org.example.Models.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacturaRepository {
    private List<Factura> facturas;

    @Autowired
    public FacturaRepository(Logic logic) {
        this.facturas = logic.getListaFacturas();
    }
    public List<Factura> findAll() {
        return facturas;
    }

    public void save(Factura nUsuario) {
        facturas.add(nUsuario);
    }
}
