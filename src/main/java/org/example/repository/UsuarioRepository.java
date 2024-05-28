package org.example.repository;

import org.example.Logic.Logic;
import org.example.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {
    private final Logic logic;
    @Autowired
    public UsuarioRepository(Logic logic) {
        this.logic = logic;
    }

    public List<Usuario> findAll() {
        return logic.getListaUsuarios();
    }

    public void save(Usuario nUsuario) {
        logic.salvarUsuario(nUsuario);
    }
}
