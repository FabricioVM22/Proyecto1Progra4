package org.example.Controllers;

import org.example.Models.Factura;
import org.example.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaController(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @PostMapping
    public void addNuevaFactura(@RequestBody Factura factura) {
        facturaRepository.save(factura);
    }
}
