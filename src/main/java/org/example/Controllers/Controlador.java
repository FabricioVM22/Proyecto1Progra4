package org.example.Controllers;
import org.example.Models.Modelo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controlador {
     @GetMapping("/")
     public String index(Model model){
         //aquí debería haber una conexion a la capa de logica que les traiga los datos por ejemplo de las facturas
         Modelo modelo1 =new Modelo("Esta es la pagina de inicio de Spring Boot");
         model.addAttribute("modelo", modelo1);
         return "index";
     }


     @GetMapping("/about")
    public String about(Model model){
         Modelo modelo =new Modelo("esta es la pagina de información");
         model.addAttribute("modelo",modelo);
         return "about";
     }

}
