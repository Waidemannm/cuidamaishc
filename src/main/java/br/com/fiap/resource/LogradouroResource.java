package br.com.fiap.resource;

import br.com.fiap.bo.LogradouroBO;
import br.com.fiap.to.LogradouroTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/logradouro")
public class LogradouroResource{
    //atributos
    private LogradouroBO logradouroBO = new LogradouroBO();
    //metodos particulares
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<LogradouroTO> resultado = logradouroBO.findAll();
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
    public Response save(@Valid LogradouroTO logradouroTO){
        LogradouroTO resultado = logradouroBO.save(logradouroTO);
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
        LogradouroTO resultado = logradouroBO.findById(id);
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
    public Response delete(@PathParam("id") Long id){
        Response.ResponseBuilder response = null;
        if(logradouroBO.delete(id)){
            response = Response.status(204);
        }else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid LogradouroTO logradouroTO, @PathParam("id") Long id){
        logradouroTO.setIdLogradouro(id);
        Response.ResponseBuilder response = null;
        LogradouroTO resultado = logradouroBO.update(logradouroTO);
        if(resultado != null){
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        return response.build();
    }
}
