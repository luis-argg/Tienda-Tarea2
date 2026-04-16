package com.luisargueta.tiendafrontend.repository;

import com.luisargueta.tiendafrontend.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
