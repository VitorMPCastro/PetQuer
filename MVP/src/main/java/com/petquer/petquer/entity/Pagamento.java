package com.petquer.petquer.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @Column(name = "id_pagamento")
    private Integer idPagamento;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "datahora", nullable = false)
    private LocalDateTime datahora;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pagamento", referencedColumnName = "id_metodo_pagamento", foreignKey = @ForeignKey(name = "pagamento_id_metodo_pagamento_fk"))
    private MetodoPagamento metodoPagamento;

    // Getters and Setters
    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}