package br.com.vivistudio.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoRequest {

    private Long telefone;
    private LocalDate data;
    private LocalTime hora;
    private String servico;

    // Getters e Setters
    public Long getTelefone() { return telefone; }
    public void setTelefone(Long telefone) { this.telefone = telefone; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getServico() { return servico; }
    public void setServico(String servico) { this.servico = servico; }
}
