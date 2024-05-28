package org.example.Controllers;

import org.example.Models.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebControlador {
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private FacturaRepository facturaRepository;
    private ProductoRepository productoRepository;
    private Usuario usuarioActual;

    @Autowired
    public WebControlador(UsuarioRepository usuarioRepository, ClienteRepository clienteRepository, FacturaRepository facturaRepository, ProductoRepository productoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.facturaRepository = facturaRepository;
        this.productoRepository = productoRepository;
    }

    //cargar pagina inicial
    @GetMapping("/")
    public String index(Model model) {
        usuarioActual = new Usuario();
        return "Index";
    }

    //cargar páginas con las listas (posiblemente no se ocupe con el JS)
    @GetMapping("/Clientes")
    public String Clientes(Model model) {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "Clientes";
    }

    @GetMapping("/Facturas")
    public String Facturas(Model model) {
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        return "Facturas";
    }

    @GetMapping("/Productos")
    public String Productos(Model model) {
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "Productos";
    }

    @GetMapping("/Administracion")
    public String Administracion(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "Administracion";
    }


    @GetMapping("/Perfil")
    public String perfil(Model model) {
        Modelo modelo = new Modelo("esta es la pagina de información");
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("modelo", modelo);
        return "Perfil";
    }

    /*forms*/
    @GetMapping("/RegistrarClientes")
    public String RegistrarCliente(Model model) {
        Modelo modeloRC = new Modelo("esta es la pagina de registro de Clientes");
        model.addAttribute("modelo", modeloRC);
        return "RegistrarClientes";
    }

    @GetMapping("/RegistrarFacturas")
    public String RegistrarFacturas(Model model) {
        Modelo modeloRF = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modeloRF);
        return "RegistrarFacturas";
    }

    @GetMapping("/RegistrarProductos")
    public String RegistrarProductos(Model model) {
        Modelo modeloRP = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modeloRP);
        return "RegistrarProductos";
    }

    @GetMapping("/RegistrarUsuarios")
    public String RegistrarUsuarios(Model model) {
        Modelo modeloRP = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modeloRP);
        return "RegistrarUsuario";
    }

    @GetMapping("/AdministrarProveedores")
    public String AdministrarProveedores(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "AdministrarProveedores";
    }

    public void base(Model model) {
        Modelo modelo = new Modelo();
        try {
            if (usuarioActual.getNombre().equals("admin")) {
                modelo.setMessage("Administracion");
            } else {
                modelo.setMessage(null);
            }
        } catch (Exception ex) {
        }

        model.addAttribute("modelo", modelo);
    }


    //carga del login y validación
    @PostMapping(path = "/login")
    public String login(@RequestBody Usuario usuarioR, Model model) {
        Usuario nUsuario = new Usuario();
        try {
            Iterable<Usuario> usuarios = usuarioRepository.findAll();
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(usuarioR.getNombre())) {
                    nUsuario = usuario;
                }
            }
            if (nUsuario.getContrasena().equals(usuarioR.getContrasena()) && nUsuario.getEstado()) {
                model.addAttribute("usuario", nUsuario);
                usuarioActual = nUsuario;
                base(model);
                return "Perfil";
            }
        } catch (Exception ex) {
        }
        return "redirect:/";
    }

}
