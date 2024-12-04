package com.petquer.petquer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "denuncia_anuncio")
public class DenunciaAnuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia_anuncio")
    private Integer idDenunciaAnuncio;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_denuncia", referencedColumnName = "id_tipo_denuncia", foreignKey = @ForeignKey(name = "anuncio_id_tipo_denuncia_fk"))
    private TipoDenuncia tipoDenuncia;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "id_usuario_fk"))
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "id_anuncio", referencedColumnName = "id_anuncio", foreignKey = @ForeignKey(name = "id_anuncio_fk"))
    private Anuncio anuncio;

    // Getters and Setters
    public Integer getIdDenunciaAnuncio() {
        return idDenunciaAnuncio;
    }

    public void setIdDenunciaAnuncio(Integer idDenunciaAnuncio) {
        this.idDenunciaAnuncio = idDenunciaAnuncio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoDenuncia getTipoDenuncia() {
        return tipoDenuncia;
    }

    public void setTipoDenuncia(TipoDenuncia tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
}