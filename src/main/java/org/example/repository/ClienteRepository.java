package org.example.repository;

import org.example.Models.Cliente;
import org.example.Logic.Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {
    private List<Cliente> clientes;
    @Autowired
    public ClienteRepository(Logic logic) {
        this.clientes = logic.getListaClientes();
    }
    public List<Cliente> findAll() {
        return clientes;
    }

    public void save(Cliente nUsuario) {
        clientes.add(nUsuario);
    }
}
