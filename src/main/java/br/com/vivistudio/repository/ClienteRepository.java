package br.com.vivistudio.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.com.vivistudio.entity.Cliente;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    // O count() já vem do PanacheRepository!
}