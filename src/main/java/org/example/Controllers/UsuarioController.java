package org.example.Controllers;

import org.example.Models.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //cargar tablas
    @GetMapping(path = "listUsuario")
    public String getAllUsers(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "Administracion";
    }
    //métodos
    @PostMapping(path = "addUsuario")
    public String addNuevoUsuario(Usuario usuario, Model model) {
        usuarioRepository.save(usuario);
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "redirect:/index";
    }

}
