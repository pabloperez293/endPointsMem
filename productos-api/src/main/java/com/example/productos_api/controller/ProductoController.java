package com.example.productos_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

// inyectamos el repo
import com.example.productos_api.repository.ProductoRepository;

import com.example.productos_api.model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoRepository productoRepository;

    // instancia del repo
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /**
     * Obtiene la lista completa de productos.
     * 
     * @return lista de productos disponibles
     */
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    /**
     * Busca un producto por su identificador.
     * 
     * @param id identificador del producto
     * @return producto encontrado o null si no existe
     */
    @GetMapping("/buscar")
    public List<Producto> buscarPorNombre(@RequestParam String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {

        return productoRepository.findById(id).orElse(null);

    }

    /**
     * Crea un nuevo producto y lo agrega a la lista en memoria.
     * 
     * @param producto datos del producto a crear
     * @return producto creado
     */
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * Actualiza los datos de un producto existente.
     * 
     * @param id                  identificador del producto a actualizar
     * @param productoActualizado datos nuevos del producto
     * @return producto actualizado o null si no existe
     */
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        Producto producto = productoRepository.findById(id).orElse(null);

        if (producto != null) {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCategoria(productoActualizado.getCategoria());

            return productoRepository.save(producto);
        }
        return null;

    }

    /**
     * Elimina un producto por su identificador.
     * 
     * @param id identificador del producto a eliminar
     * @return mensaje indicando si el producto fue eliminado o no
     */
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {

        if (productoRepository.existsById(id)) {

            productoRepository.deleteById(id);

            return "producto eliminado correctamente";

        }
        return "producto no encontrado :)";
    }

}
