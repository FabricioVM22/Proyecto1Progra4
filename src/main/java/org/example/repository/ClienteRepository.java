package org.example.repository;

import org.example.Models.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteRepository  extends CrudRepository<Cliente,Integer>{
}
