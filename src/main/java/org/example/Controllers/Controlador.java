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

@Controller
@RequestMapping(path = "/")
public class Controlador {
    //Bases de datos para Usuarios
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping(path="add")
    public @ResponseBody String addNuevoUsuario(@RequestParam String nombre, @RequestParam String email){

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);
        usuarioRepository.save(nuevoUsuario);
        return "Guardado! ";
    }

    @GetMapping(path = "list")
    public String getAllUsers(Model model)
    {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios",usuarios);
        return "Administracion";
    }
    //Bases de datos para Clientes
    @Autowired
    private ClienteRepository clienteRepository;
    @PostMapping(path="add")
    public @ResponseBody String addNuevoCliente(@RequestParam String nombre,@RequestParam String tipoCedula, @RequestParam String email){

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setTipoCedula(tipoCedula);
        nuevoCliente.setEmail(email);
        clienteRepository.save(nuevoCliente);
        return "Guardado! ";
    }

    @GetMapping(path = "list")
    public String getAllClientes(Model model)
    {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes",clientes);
        return "Clientes";
    }
    //Bases de datos para Facturas
    @Autowired
    private FacturaRepository facturaRepository;
    @PostMapping(path="add")
    public @ResponseBody String addNuevaFactura(@RequestParam String cliente, @RequestParam String email){

        Factura nuevaFactura = new Factura();
        nuevaFactura.setCliente(cliente);
        nuevaFactura.setEmail(email);
        facturaRepository.save(nuevaFactura);
        return "Guardado! ";
    }

    @GetMapping(path = "list")
    public String getAllFacturas(Model model)
    {
        Iterable<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas",facturas);
        return "Facturas";
    }
    //Bases de datos para Productos
    @Autowired
    private ProductoRepository productoRepository;
    @PostMapping(path="add")
    public @ResponseBody String addNuevoProducto(@RequestParam String descripcion, @RequestParam int cantidad){

        Producto nuevoProducto = new Producto();
        nuevoProducto.setDescripcion(descripcion);
        nuevoProducto.setCantidad(cantidad);
        facturaRepository.save(nuevoProducto);
        return "Guardado! ";
    }

    @GetMapping(path = "list")
    public String getAllProductos(Model model)
    {
        Iterable<Producto> productos = facturaRepository.findAll();
        model.addAttribute("productos",productos);
        return "Producto";
    }



    /*paginas base*/
    @GetMapping("/")
    public String index(Model model) {
        //aquí debería haber una conexion a la capa de logica que les traiga los datos por ejemplo de las facturas
        Modelo modelo1 = new Modelo("Esta es la pagina de inicio del sistema :D");
        model.addAttribute("modelo", modelo1);
        return "index";
    }

    @GetMapping("/Clientes")
    public String Clientes(Model model) {
        Modelo modeloC = new Modelo("esta es la pagina de vista de Clientes");
        model.addAttribute("modelo", modeloC);
        return "Clientes";
    }

    @GetMapping("/Facturas")
    public String Facturas(Model model) {
        Modelo modeloF = new Modelo("esta es la pagina de vista de Facturas");
        model.addAttribute("modelo", modeloF);
        return "Facturas";
    }
    @GetMapping("/Productos")
    public String Productos(Model model) {
        Modelo modeloP = new Modelo("esta es la pagina de vista de Productos");
        model.addAttribute("modelo", modeloP);
        return "Productos";
    }
    @GetMapping("/Administracion")
    public String Administracion(Model model) {
        Modelo modeloA = new Modelo("esta es la pagina de administracion");
        model.addAttribute("modelo", modeloA);
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
    /*about*/
    @GetMapping("/about")
    public String about(Model model) {
        Modelo modelo = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modelo);
        return "about";
    }

}
