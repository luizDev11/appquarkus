package br.com.vivistudio.resource;

import br.com.vivistudio.entity.Agendamento;
import br.com.vivistudio.entity.Cliente;
import br.com.vivistudio.request.AgendamentoRequest;
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

        return Response.ok(agendamento).build();
    }
    @GET
    @Path("/buscarPorTelefone")
    public Cliente buscarPorTelefone(@QueryParam("telefone") String telefone) {
        return Cliente.find("telefone", telefone).firstResult();
    }


    @POST
    @Transactional
    public Response criarAgendamento(AgendamentoRequest request) {
        Cliente cliente = Cliente.find("telefone", request.getTelefone()).firstResult();
        if (cliente == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Cliente não existe, não é possível agendar")
                    .build();
        }

        Agendamento agendamento = new Agendamento();
        agendamento.cliente = cliente;
        agendamento.data = request.getData();
        agendamento.hora = request.getHora();
        agendamento.servico = request.getServico();
        agendamento.persist();

        return Response.status(Response.Status.CREATED)
                .entity("Agendamento criado com sucesso!")
                .build();
    }


    @PUT
    @Transactional
    @Path("/{id}")
    public Response atualizarAgendamento(@PathParam("id") Long id, Agendamento dados) {
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
        agendamento.persist();

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
