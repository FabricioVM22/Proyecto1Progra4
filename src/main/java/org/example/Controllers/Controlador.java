package org.example.Controllers;

import org.example.Models.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private FacturaRepository facturaRepository;
    private ProductoRepository productoRepository;
    private Usuario usuarioActual;

    @Autowired
    public Controlador(UsuarioRepository usuarioRepository, ClienteRepository clienteRepository, FacturaRepository facturaRepository, ProductoRepository productoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.facturaRepository = facturaRepository;
        this.productoRepository = productoRepository;
    }


    //cargar tablas
    @GetMapping(path = "listUsuario")
    public String getAllUsers(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "Administracion";
    }

    @GetMapping(path = "listCliente")
    public String getAllClientes(Model model) {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "Clientes";
    }

    @GetMapping(path = "listFacturad")
    public String getAllFacturas(Model model) {
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        return "Facturas";
    }

    @GetMapping(path = "listProductos")
    public String getAllProductos(Model model) {
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "Producto";
    }



    //métodos
    @PostMapping(path = "addUsuario")
    public String addNuevoUsuario(Usuario usuario, Model model) {
        usuarioRepository.save(usuario);
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        base(model);                                                                    //?
        return "redirect:/index";
    }

    @PostMapping(path = "addCliente")
    public String addNuevoCliente(Cliente cliente, Model model) {
        clienteRepository.save(cliente);
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        base(model);
        return "redirect:/Clientes";
    }

    @PostMapping(path = "addFactura")
    public String addNuevaFactura(Factura factura, Model model) {
        facturaRepository.save(factura);
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        base(model);
        return "redirect:/Facturas";
    }

    @PostMapping(path = "addProducto")
    public String addNuevoProducto(Producto producto, Model model) {
        productoRepository.save(producto);
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        base(model);
        return "Productos";
    }

    @PostMapping(path = "/login")
    public String login(@RequestParam("usuario") String usuarioNombre, @RequestParam("clave") String clave, Model model) {
        Usuario nUsuario = new Usuario();
        try {
            Iterable<Usuario> usuarios = usuarioRepository.findAll();
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(usuarioNombre)) {
                    nUsuario = usuario;
                }
            }
            if (nUsuario.getContrasena().equals(clave) && nUsuario.getEstado()) {
                model.addAttribute("usuario", nUsuario);
                usuarioActual = nUsuario;
                base(model);
                return "Perfil";
            }
        } catch (Exception ex) {
        }
        return "redirect:/";
    }

    //cargar paginas
    @GetMapping("/")
    public String index(Model model) {
        usuarioActual = new Usuario();
        base(model);
        return "Index";
    }

    @GetMapping("/Clientes")
    public String Clientes(Model model) {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        base(model);
        return "Clientes";
    }

    @GetMapping("/Facturas")
    public String Facturas(Model model) {
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        base(model);
        return "Facturas";
    }

    @GetMapping("/Productos")
    public String Productos(Model model) {
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        base(model);
        return "Productos";
    }

    @GetMapping("/Administracion")
    public String Administracion(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        base(model);
        return "Administracion";
    }

    /*forms*/
    @GetMapping("/RegistrarClientes")
    public String RegistrarCliente(Model model) {
        Modelo modeloRC = new Modelo("esta es la pagina de registro de Clientes");
        model.addAttribute("modelo", modeloRC);
        base(model);
        return "RegistrarClientes";
    }

    @GetMapping("/RegistrarFacturas")
    public String RegistrarFacturas(Model model) {
        Modelo modeloRF = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modeloRF);
        base(model);
        return "RegistrarFacturas";
    }

    @GetMapping("/RegistrarProductos")
    public String RegistrarProductos(Model model) {
        Modelo modeloRP = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modeloRP);
        base(model);
        return "RegistrarProductos";
    }

    @GetMapping("/RegistrarUsuarios")
    public String RegistrarUsuarios(Model model) {
        Modelo modeloRP = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modeloRP);
        base(model);
        return "RegistrarUsuario";
    }

    @GetMapping("/AdministrarProveedores")
    public String AdministrarProveedores(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        base(model);
        return "AdministrarProveedores";
    }

    @GetMapping("/Perfil")
    public String perfil(Model model) {
        Modelo modelo = new Modelo("esta es la pagina de información");
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("modelo", modelo);
        base(model);
        return "Perfil";
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
}
