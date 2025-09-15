package br.gov.sp.fatec.springtopicos20252.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ace_acesso")
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ace_id")
    private Long id;

    @Column(name = "ace_tipo", nullable = false)
    private String tipo;

    @Column(name = "ace_origem")
    private String origem;

    @Column(name = "ace_data_hora_inicio")
    private LocalDateTime dataHoraInicio;

    @Column(name = "ace_tempo_acesso")
    private Integer tempoAcesso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ace_usuario")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Integer getTempoAcesso() {
        return tempoAcesso;
    }

    public void setTempoAcesso(Integer tempoAcesso) {
        this.tempoAcesso = tempoAcesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
