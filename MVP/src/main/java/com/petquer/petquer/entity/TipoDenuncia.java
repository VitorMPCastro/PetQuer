package com.petquer.petquer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_denuncia")
public class TipoDenuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_denuncia")
    private Long idTipoDenuncia;
    private String tipo;

    public Long getIdTipoDenuncia() {
        return idTipoDenuncia;
    }

    public void setIdTipoDenuncia(Long idTipoDenuncia) {
        this.idTipoDenuncia = idTipoDenuncia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}