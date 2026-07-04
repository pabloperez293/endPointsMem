package com.example.productos_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productos_api.Model.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/productos")
public class ProductoController {
    private List<Producto> productos = new ArrayList<>();

    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
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
       
}
