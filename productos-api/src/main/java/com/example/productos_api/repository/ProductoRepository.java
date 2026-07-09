package com.example.productos_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productos_api.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si es necesario
    List<Producto> findByNombre(String nombre);
}