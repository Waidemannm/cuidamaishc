package br.com.fiap.resource;

import br.com.fiap.bo.PacienteBO;
import br.com.fiap.to.PacienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/paciente")
public class PacienteResource {
    //atributos
    private PacienteBO pacienteBO = new PacienteBO();
    //metodos particulares
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<PacienteTO> resultado = pacienteBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        }
        else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid PacienteTO pacienteTO){
        PacienteTO resultado = pacienteBO.save(pacienteTO);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        PacienteTO resultado = pacienteBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        }
        else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(Long id){
        Response.ResponseBuilder response = null;
        if(pacienteBO.delete(id)){
            response = Response.status(204);
        }else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid PacienteTO pacienteTO, @PathParam("id") Long id){
        pacienteTO.setIdPaciente(id);
        Response.ResponseBuilder response = null;
        PacienteTO resultado = pacienteBO.update(pacienteTO);
        if(resultado != null){
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
