package br.com.fiap.resource;

import br.com.fiap.bo.ConsultaBO;
import br.com.fiap.to.ConsultaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/consulta")
public class ConsultaResource {
    //atributos
    private ConsultaBO consultaBO = new ConsultaBO();
    //metodos particulares
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<ConsultaTO> resultado = consultaBO.findAll();
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
    public Response save(@Valid ConsultaTO consultaTO){
        ConsultaTO resultado = consultaBO.save(consultaTO);
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
        ConsultaTO resultado = consultaBO.findById(id);
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
        if(consultaBO.delete(id)){
            response = Response.status(204);
        }else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ConsultaTO consultaTO, @PathParam("id") Long id){
        consultaTO.setIdConsulta(id);
        Response.ResponseBuilder response = null;
        ConsultaTO resultado = consultaBO.update(consultaTO);
        if(resultado != null){
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
