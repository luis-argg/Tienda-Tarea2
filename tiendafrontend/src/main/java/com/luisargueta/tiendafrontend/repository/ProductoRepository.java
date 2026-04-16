package com.luisargueta.tiendafrontend.repository;

import com.luisargueta.tiendafrontend.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}


