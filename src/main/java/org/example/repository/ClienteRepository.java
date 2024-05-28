package org.example.repository;

import org.example.Models.Cliente;
import org.example.Logic.Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {
    private final Logic logic;  // Declarar la instancia de Logic

    @Autowired
    public ClienteRepository(Logic logic) {
        this.logic = logic;  // Inicializar la instancia de Logic
    }

    public List<Cliente> findAll() {
        return logic.getListaClientes();
    }

    public void save(Cliente nUsuario) {
        logic.salvarCliente(nUsuario);  // Llamar a un método de la instancia Logic
    }
}
