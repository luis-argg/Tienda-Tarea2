package com.luisargueta.tiendafrontend.repository;

import com.luisargueta.tiendafrontend.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
