package br.com.vivistudio.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Agendamento extends PanacheEntity {

    public LocalDate data;

    public LocalTime hora;

    public String servico;

    @ManyToOne
    @JoinColumn(nullable = true)
    public Cliente cliente;

}
