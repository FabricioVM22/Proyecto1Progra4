package org.example.Datos;

import org.example.Models.Producto;
import org.springframework.data.repository.CrudRepository;

public interface DatosProductos extends CrudRepository<Producto,Integer> {
}
