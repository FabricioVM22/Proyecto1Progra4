package org.example.repository;

import org.example.Logic.Logic;
import org.example.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {
    private List<Usuario> usuarios;

    @Autowired
    public UsuarioRepository(Logic logic) {
        this.usuarios = logic.getListaUsuarios();
    }

    public List<Usuario> findAll() {
        return usuarios;
    }

    public void save(Usuario nUsuario) {
        usuarios.add(nUsuario);
    }
}
