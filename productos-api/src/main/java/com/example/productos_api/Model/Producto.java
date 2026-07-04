package com.example.productos_api.Model;

/**
 * Representa un producto del sistema.
 * Esta clase sirve como modelo de datos para la API REST.
 */
public class Producto {

    /** Identificador único del producto. */
    private Long id;

    /** Nombre del producto. */
    private String nombre;

    /** Precio del producto. */
    private double precio;

    /**
     * Constructor vacío requerido para la deserialización JSON.
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros para crear un producto de forma directa.
     *
     * @param id     identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     */
    public Producto(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
