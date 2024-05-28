package org.example.Logic;

import org.example.Datos.*;
import org.example.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Logic {

    private DatosClientes listaClientes;
    private DatosFacturas listaFacturas;
    private DatosProductos listaProductos;
    private DatosUsuarios listaUsuarios;

    @Autowired
    public Logic(DatosClientes listaClientes, DatosFacturas listaFacturas, DatosProductos listaProductos, DatosUsuarios listaUsuarios) {
        this.listaClientes = listaClientes;
        this.listaFacturas = listaFacturas;
        this.listaProductos = listaProductos;
        this.listaUsuarios = listaUsuarios;
    }

    public List<Cliente> getListaClientes() {
        return (List<Cliente>) listaClientes.findAll();
    }

    public List<Factura>  getListaFacturas() {
        return (List<Factura>) listaFacturas.findAll();
    }

    public List<Producto> getListaProductos() {
        return (List<Producto>) listaProductos.findAll();
    }

    public List<Usuario> getListaUsuarios() {
        return (List<Usuario>) listaUsuarios.findAll();
    }

    public void salvarCliente(Cliente cliente) {
        listaClientes.save(cliente);
    }

    public void salvarFactura(Factura factura) {
        listaFacturas.save(factura);
    }

    public void salvarProducto(Producto producto) {
        listaProductos.save(producto);
    }

    public void salvarUsuario(Usuario usuario) {
        listaUsuarios.save(usuario);
    }

}
