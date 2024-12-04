package com.petquer.petquer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review_anuncio")
public class ReviewAnuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review_anuncio")
    private Integer idReviewAnuncio;

    @Column(name = "nota", nullable = false)
    private Integer nota;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "avaliacao", nullable = false)
    private Integer avaliacao;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", foreignKey = @ForeignKey(name = "id_reserva_fk"))
    private Reserva reserva;

    // Getters and Setters
    public Integer getIdReviewAnuncio() {
        return idReviewAnuncio;
    }

    public void setIdReviewAnuncio(Integer idReviewAnuncio) {
        this.idReviewAnuncio = idReviewAnuncio;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}