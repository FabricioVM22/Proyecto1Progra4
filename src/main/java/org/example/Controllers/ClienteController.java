package org.example.Controllers;

import org.example.Models.Cliente;
import org.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping(path = "listCliente")
    public String getAllClientes(Model model) {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "Clientes";
    }

    @PostMapping(path = "addCliente")
    public String addNuevoCliente(Cliente cliente, Model model) {
        clienteRepository.save(cliente);
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "redirect:/Clientes";
    }

}
