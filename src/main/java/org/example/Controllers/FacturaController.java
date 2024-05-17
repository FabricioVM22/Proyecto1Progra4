package org.example.Controllers;

import org.example.Models.Factura;
import org.example.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class FacturaController {
    private final FacturaRepository facturaRepository;

    public FacturaController(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @GetMapping(path = "listFacturad")
    public String getAllFacturas(Model model) {
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        return "Facturas";
    }

    @PostMapping(path = "addFactura")
    public String addNuevaFactura(Factura factura, Model model) {
        facturaRepository.save(factura);
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        return "redirect:/Facturas";
    }
}
