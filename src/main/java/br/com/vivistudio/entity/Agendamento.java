package br.com.vivistudio.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.math.BigDecimal;

@Entity
public class Agendamento extends PanacheEntity {

    public LocalDate data;

    public LocalTime hora;

    @ManyToOne
    public Servico servico;

    @ManyToOne
    @JoinColumn(nullable = true)
    public Cliente cliente;

    public BigDecimal valor;

    @Enumerated(EnumType.STRING)
    public StatusAgendamento statusAgendamento;

    public LocalDateTime realizadoEm;


}
