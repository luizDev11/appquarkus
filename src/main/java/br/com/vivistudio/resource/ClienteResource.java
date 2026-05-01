package br.com.vivistudio.resource;

import br.com.vivistudio.entity.Cliente;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/clientes")
public class ClienteResource {

    @GET
    public List<Cliente> listar() {
        return Cliente.listAll();
    }
}
