package org.example.Datos;

import org.example.Models.Factura;
import org.springframework.data.repository.CrudRepository;

public interface DatosFacturas extends CrudRepository<Factura,Integer>{
}
