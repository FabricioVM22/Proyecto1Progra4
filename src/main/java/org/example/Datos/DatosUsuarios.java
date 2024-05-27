package org.example.Datos;

import org.example.Models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface DatosUsuarios extends CrudRepository<Usuario,Integer>{
}
