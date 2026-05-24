package br.com.vivistudio.resource;

import br.com.vivistudio.entity.Agendamento;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/agendamentos")
public class AgendamentoResourse {

    @GET
    public List<Agendamento> listar() {
        return Agendamento.listAll();
    }

    @Path("/{id}")
    @GET
    public Response buscarAgendamentoPorId(@PathParam("id") Long id) {
        Agendamento agendamento = Agendamento.findById(id);

        if (agendamento == null) {

            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Agendamento não encontrado")
                    .build();
        }
        agendamento.persist();

        return Response.status(Response.Status.CREATED)
                .entity("Agendamento criado com sucesso")
                .build();

    }

    @POST
    @Transactional
    public Response criarAgendamento(Agendamento agendamento) {

        if (agendamento == null) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Confira dados")
                    .build();
        }

        agendamento.persist();

        return Response.ok(agendamento).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response atualizarAgendamento(
            @PathParam("id") Long id,
            Agendamento dados) {

        Agendamento agendamento = Agendamento.findById(id);

        if (agendamento == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Agendamento não encontrado")
                    .build();
        }

        agendamento.data = dados.data;
        agendamento.hora = dados.hora;
        agendamento.servico = dados.servico;
        agendamento.cliente = dados.cliente;

        return Response.ok(agendamento).build();

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletarAgendamentoPorId (@PathParam("id") Long id) {

       boolean deletado = Agendamento.deleteById(id);

       if(!deletado){

           return Response.status(Response.Status.NOT_FOUND)
                   .entity("Agendamento não encontrado")
                   .build();
       }
       return Response.noContent().build();


    }



}
