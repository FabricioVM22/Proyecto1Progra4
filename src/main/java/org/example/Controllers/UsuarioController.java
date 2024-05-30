package org.example.Controllers;

import org.example.Models.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public void addNuevoUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public void updateUsuarioEstado(@PathVariable int id, @RequestBody boolean estado) {
        Usuario usuario = usuarioRepository.findById(id);
            usuario.setEstado(estado); // Asumiendo que Usuario tiene un método setEstado
            usuarioRepository.save(usuario);
    }
}
