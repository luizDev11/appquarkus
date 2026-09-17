package br.com.vivistudio.resource;

import br.com.vivistudio.entity.Servico;
import br.com.vivistudio.entity.StatusServico;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/servicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicoResource {

    @POST
    @Transactional
    public Response criar(Servico servico) {

        servico.statusServico = StatusServico.ATIVO;
        servico.persist();

        return Response.status(Response.Status.CREATED)
                .entity(servico)
                .build();
    }

    @GET
    public List<Servico> listar() {

        return Servico.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {

        Servico servico = Servico.findById(id);

        if (servico == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(servico).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(
            @PathParam("id") Long id,
            Servico dados
    ) {

        Servico servico = Servico.findById(id);

        if (servico == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        servico.nome = dados.nome;
        servico.valor = dados.valor;

        servico.persist();

        return Response.ok(servico).build();
    }

    @PUT
    @Path("/{id}/ativar")
    public Response ativar(@PathParam("id") Long id) {

        Servico servico = Servico.findById(id);

        if (servico == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        servico.statusServico = StatusServico.ATIVO;
        servico.persist();

        return Response.ok(servico).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response desativar(@PathParam("id") Long id) {

        Servico servico = Servico.findById(id);

        if (servico == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        servico.statusServico = StatusServico.INATIVO;
        servico.persist();

        return Response.ok(servico).build();
    }
}