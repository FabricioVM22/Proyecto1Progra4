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

import java.util.Iterator;
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
    public String addNuevoUsuario(@RequestParam("nombre") String nombre,@RequestParam("clave") String clave, @RequestParam("correo") String email) {

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setContrasena(clave);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setEstado(false);
        usuarioRepository.save(nuevoUsuario);
        return "index";
    }

    @GetMapping(path = "listUsuario")
    public String getAllUsers(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "Administracion";
    }

    @PostMapping(path = "/actualizarUsuarios")
    public String actualizarUsuarios(@RequestParam("estadoUsuario") String estadosUsuarios, Model model) {


        // Obtener todos los usuarios del repositorio
        Iterable<Usuario> usuarios = usuarioRepository.findAll();

        // Dividir el String de estados en un array de Strings
        String[] estadosArray = estadosUsuarios.split(",");

        // Iterar sobre cada usuario y asignarle su respectivo estado
        Iterator<Usuario> usuarioIterator = usuarios.iterator();
        int index = 0;
        while (usuarioIterator.hasNext() && index < estadosArray.length) {
            Usuario usuario = usuarioIterator.next();
            String estadoStr = estadosArray[index].trim(); // Limpiar espacios en blanco
            boolean estado = Boolean.parseBoolean(estadoStr); // Convertir a boolean
            usuario.setEstado(estado);
            usuarioRepository.save(usuario);
            index++;
        }

        // Añadir los usuarios actualizados al modelo
        model.addAttribute("usuarios", usuarios);
        base(model);
        // Devolver la vista deseada
        return "Administracion";
    }

    //Bases de datos para Clientes
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(path = "addCliente")
    public String addNuevoCliente(@RequestParam("nombre") String nombre, @RequestParam("tipo_cedula") String tipoCedula, @RequestParam("correo") String email, Model model) {

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setTipoCedula(tipoCedula);
        nuevoCliente.setEmail(email);
        clienteRepository.save(nuevoCliente);
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        base(model);
        return "Clientes";
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
    public String addNuevaFactura(@RequestParam("cliente") String cliente, @RequestParam("correo") String email, Model model  ) {

        Factura nuevaFactura = new Factura();
        nuevaFactura.setCliente(cliente);
        nuevaFactura.setEmail(email);
        facturaRepository.save(nuevaFactura);
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        base(model);
        return "Facturas";
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
    public String addNuevoProducto(@RequestParam("descripcion") String descripcion, @RequestParam("cantidad") int cantidad, Model model) {

        Producto nuevoProducto = new Producto();
        nuevoProducto.setDescripcion(descripcion);
        nuevoProducto.setCantidad(cantidad);
        productoRepository.save(nuevoProducto);
        Iterable<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        base(model);
        return "Producto";
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

    /*paginas base*/
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
            if(usuarioActual.getNombre().equals("admin")){
                modelo.setMessage("Administracion");
            }else{
                modelo.setMessage(null);
            }
        }catch (Exception ex){}

        model.addAttribute("modelo", modelo);
    }
}
