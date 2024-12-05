package com.petquer.petquer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "denuncia_usuario")
public class DenunciaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia_usuario")
    private Integer idDenunciaUsuario;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_denuncia", referencedColumnName = "id_tipo_denuncia", foreignKey = @ForeignKey(name = "usuario_id_tipo_denuncia_fk"))
    private TipoDenuncia tipoDenuncia;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "usuario_id_usuario_fk"))
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "alvo", referencedColumnName = "id", foreignKey = @ForeignKey(name = "Alvo_fk"))
    private User alvo;

    // Getters and Setters
    public Integer getIdDenunciaUsuario() {
        return idDenunciaUsuario;
    }

    public void setIdDenunciaUsuario(Integer idDenunciaUsuario) {
        this.idDenunciaUsuario = idDenunciaUsuario;
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

    public User getAlvo() {
        return alvo;
    }

    public void setAlvo(User alvo) {
        this.alvo = alvo;
    }
}