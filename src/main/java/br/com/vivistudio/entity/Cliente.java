package br.com.vivistudio.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Cliente extends PanacheEntity {

    public long id;

    @NotBlank(message = "O nome não deve ser vazio")
    public String nome;

    @NotBlank(message = "O telefone não deve ser vazio")
    public String telefone;



}
