package br.com.fiap.resource;

import br.com.fiap.bo.UnidadeHCBO;
import br.com.fiap.to.UnidadeHCTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/unidadeHC")
public class UnidadeHCResource {
    //atributos
    private UnidadeHCBO unidadeHCBO = new UnidadeHCBO();
    //metodos particulares
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<UnidadeHCTO> resultado = unidadeHCBO.findAll();
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
    public Response save(@Valid UnidadeHCTO unidadeHCTO){
        UnidadeHCTO resultado = unidadeHCBO.save(unidadeHCTO);
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
        UnidadeHCTO resultado = unidadeHCBO.findById(id);
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
        if(unidadeHCBO.delete(id)){
            response = Response.status(204);
        }else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid UnidadeHCTO unidadeHCTO, @PathParam("id") Long id){
        unidadeHCTO.setIdUnidade(id);
        Response.ResponseBuilder response = null;
        UnidadeHCTO resultado = unidadeHCBO.update(unidadeHCTO);
        if(resultado != null){
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        return response.build();
    }

}
