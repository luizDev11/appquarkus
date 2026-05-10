package br.com.vivistudio.resource;

import jakarta.transaction.Transactional;
import br.com.vivistudio.entity.Cliente;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/clientes")
public class ClienteResource {

    @GET
    public List<Cliente> listar() {
        return Cliente.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Cliente cliente = Cliente.findById(id);

        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }

    @POST
    @Transactional
    @Path("/criar")
    public Response criarCliente(Cliente cliente) {

        if (cliente.nome == null || cliente.telefone == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Nome e Telefone devem ser obrigatórios!")
                    .build();
        }
        cliente.persist();

        return Response.status(Response.Status.CREATED)
                .entity("Cliente criado!")
                .build();

    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarCliente(
            @PathParam("id") long id,
            Cliente dados) {
        Cliente cliente = Cliente.findById(id);

        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Cliente não encontrado")
                    .build();
        }
        cliente.nome = dados.nome;
        cliente.telefone = dados.telefone;

        return Response.ok(cliente).build();
    }


    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletarCliente(@PathParam("id") Long id) {
        boolean deletado = Cliente.deleteById(id);

        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Cliente não encontrado")
                    .build();
        }

        return Response.noContent().build();
    }

}
