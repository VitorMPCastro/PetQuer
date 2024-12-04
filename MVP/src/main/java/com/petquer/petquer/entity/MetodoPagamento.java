package com.petquer.petquer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pagamento")
public class MetodoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pagamento")
    private Integer idMetodoPagamento;

    @Column(name = "metodo", nullable = false, length = 20)
    private String metodo;

    // Getters and Setters
    public Integer getIdMetodoPagamento() {
        return idMetodoPagamento;
    }

    public void setIdMetodoPagamento(Integer idMetodoPagamento) {
        this.idMetodoPagamento = idMetodoPagamento;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}