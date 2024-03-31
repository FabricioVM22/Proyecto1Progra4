package org.example.Controllers;

import org.example.Models.Modelo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controlador {
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

    /*about*/
    @GetMapping("/about")
    public String about(Model model) {
        Modelo modelo = new Modelo("esta es la pagina de información");
        model.addAttribute("modelo", modelo);
        return "about";
    }

}
