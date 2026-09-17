package br.com.vivistudio.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Cliente extends PanacheEntity {

    @NotBlank(message = "O nome não deve ser vazio")
    public String nome;

    @NotBlank(message = "O telefone não deve ser vazio")
    public String telefone;

    public LocalDateTime dataCadastro;

    public LocalDateTime ultimaVisita;

    public BigDecimal totalGasto12m;

    @Enumerated(EnumType.STRING)
    public StatusCliente statusCliente;

}
