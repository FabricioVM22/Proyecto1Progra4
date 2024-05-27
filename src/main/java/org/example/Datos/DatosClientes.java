package org.example.Datos;

import org.example.Models.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface DatosClientes extends CrudRepository<Cliente,Integer>{
}
