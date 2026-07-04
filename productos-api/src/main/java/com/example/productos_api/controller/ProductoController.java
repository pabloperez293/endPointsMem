package com.example.productos_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productos_api.Model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    // Lista en memoria para almacenar los productos durante la ejecución de la aplicación.
    // En un proyecto real, esta información se guardaría en una base de datos.
    private final List<Producto> productos = new ArrayList<>();

    /**
     * Obtiene la lista completa de productos.
     * @return lista de productos disponibles
     */
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productos;
    }

    /**
     * Busca un producto por su identificador.
     * @param id identificador del producto
     * @return producto encontrado o null si no existe
     */
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        for (Producto producto : productos) {
            if (producto.getId() != null && producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Crea un nuevo producto y lo agrega a la lista en memoria.
     * @param producto datos del producto a crear
     * @return producto creado
     */
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }

    /**
     * Actualiza los datos de un producto existente.
     * @param id identificador del producto a actualizar
     * @param productoActualizado datos nuevos del producto
     * @return producto actualizado o null si no existe
     */
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        for (Producto producto : productos) {
            if (producto.getId() != null && producto.getId().equals(id)) {
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                return producto;
            }
        }
        return null;
    }

    /**
     * Elimina un producto por su identificador.
     * @param id identificador del producto a eliminar
     * @return mensaje indicando si el producto fue eliminado o no
     */
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        for (Producto producto : productos) {
            if (producto.getId() != null && producto.getId().equals(id)) {
                productos.remove(producto);
                return "producto eliminado";
            }
        }
        return "Producto no encontrado";
    }
}
