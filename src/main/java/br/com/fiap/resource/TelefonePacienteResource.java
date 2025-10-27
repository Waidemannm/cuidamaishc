package br.com.fiap.resource;

import br.com.fiap.bo.TelefonePacienteBO;
import br.com.fiap.to.TelefonePacienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/telefonePaciente")
public class TelefonePacienteResource {
    //atributos
    private TelefonePacienteBO telefonePacienteBO = new TelefonePacienteBO();
    //metodos particulares
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<TelefonePacienteTO> resultado = telefonePacienteBO.findAll();
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
    public Response save(@Valid TelefonePacienteTO telefonePacienteTO){
        TelefonePacienteTO resultado = telefonePacienteBO.save(telefonePacienteTO);
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
        TelefonePacienteTO resultado =  telefonePacienteBO.findById(id);
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
        if(telefonePacienteBO.delete(id)){
            response = Response.status(204);
        }else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid TelefonePacienteTO telefonePacienteTO, @PathParam("id") Long id){
        telefonePacienteTO.setIdTelefone(id);
        Response.ResponseBuilder response = null;
        TelefonePacienteTO resultado = telefonePacienteBO.update(telefonePacienteTO);
        if(resultado != null){
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        return response.build();
    }
}
