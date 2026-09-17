package br.com.vivistudio.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Entity
public class Servico extends PanacheEntity {

    public String nome;

    public BigDecimal valor;

    @Enumerated(EnumType.STRING)
    public StatusServico statusServico;


}

