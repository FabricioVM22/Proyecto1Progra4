package org.example.Controllers;

import org.example.Models.*;
import org.example.repository.ClienteRepository;
import org.example.repository.FacturaRepository;
import org.example.repository.ProductoRepository;
import org.example.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class Controlador {
    //Bases de datos para Usuarios
    @Autowired
    private UsuarioRepository usuarioRepository;
    Usuario usuarioActual;

    @PostMapping(path = "addUsuario")
    public @ResponseBody String addNuevoUsuario(@RequestParam String nombre, @RequestParam String email) {

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);
        usuarioRepository.save(nuevoUsuario);
        return "Guardado! ";
    }

    @GetMapping(path = "listUsuario")
    public String getAllUsers(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "Administracion";
    }

    //Bases de datos para Clientes
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(path = "addCliente")
    public @ResponseBody String addNuevoCliente(@RequestParam("nombre") String nombre, @RequestParam("tipoCedula") String tipoCedula, @RequestParam("correo") String email) {

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setTipoCedula(tipoCedula);
        nuevoCliente.setEmail(email);
        clienteRepository.save(nuevoCliente);
        return "Guardado! ";
    }

    @GetMapping(path = "listCliente")
    public String getAllClientes(Model model) {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "Clientes";
    }

    //Bases de datos para Facturas
    @Autowired
    private FacturaRepository facturaRepository;

    @PostMapping(path = "addFactura")
    public @ResponseBody String addNuevaFactura(@RequestParam("cliente") String cliente, @RequestParam("correo") String email) {

        Factura nuevaFactura = new Factura();
        nuevaFactura.setCliente(cliente);
        nuevaFactura.setEmail(email);
        facturaRepository.save(nuevaFactura);
        return "Guardado! ";
    }

    @GetMapping(path = "listFacturad")
    public String getAllFacturas(Model model) {
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        return "Facturas";
    }

    //Bases de datos para Productos
    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(path = "addProducto")
    public @ResponseBody String addNuevoProducto(@RequestParam("descripcion") String descripcion, @RequestParam("cantidad") int cantidad) {

        Producto nuevoProducto = new Producto();
        nuevoProducto.setDescripcion(descripcion);
        nuevoProducto.setCantidad(cantidad);
        productoRepository.save(nuevoProducto);
        return "Guardado! ";
    }

    @GetMapping(path = "listProductos")
    public String getAllProductos(Model model) {
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "Producto";
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
            if (nUsuario.getContrasena().equals(clave)) {
                model.addAttribute("usuario", nUsuario);
                usuarioActual = nUsuario;
                return "Perfil";
            }
        } catch (Exception ex) {
        }
        return "redirect:/";
    }

    /*paginas base*/
    @GetMapping("/")
    public String index(Model model) {
        usuarioActual = new Usuario();
        return "Index";
    }

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

    @GetMapping("/AdministrarProveedores")
    public String AdministrarProveedores(Model model) {
        Modelo modeloAP = new Modelo("esta es la pagina de administracion de proveedores");
        model.addAttribute("modelo", modeloAP);
        return "AdministrarProveedores";
    }

    @GetMapping("/Perfil")
    public String perfil(Model model) {
        Modelo modelo = new Modelo("esta es la pagina de información");
        model.addAttribute("usuario", usuarioActual);
        model.addAttribute("modelo", modelo);
        return "Perfil";
    }

}
