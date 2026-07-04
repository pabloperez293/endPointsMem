package com.example.productos_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productos_api.Model.Producto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private List<Producto> productos = new ArrayList<>();

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productos;
    }
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
    return null; // Retorna null si no se encuentra el producto con el ID especificado
    }
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        //TODO: process POST request
        productos.add(producto);
        return producto;
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        //TODO: process PUT request
        for (Producto producto : productos) {

            if (producto.getId().equals(id)) {

                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                return producto;
            }
        }
        return null; // Retorna null si no se encuentra el producto con el ID especificado
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        // agregar delete
        for (Producto producto : productos) {

            if(producto.getId().equals(id)) {
                productos.remove(producto);

                return "productos eliminados";
            }

        }
        return "Producto no encontrado";
    }
       
}
