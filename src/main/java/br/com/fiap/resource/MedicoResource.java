package br.com.fiap.resource;

import br.com.fiap.bo.MedicoBO;
import br.com.fiap.to.MedicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/medico")
public class MedicoResource{
    //atributos
    private MedicoBO medicoBO = new MedicoBO();
    //metodos particulares
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<MedicoTO> resultado = medicoBO.findAll();
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
    public Response save(@Valid MedicoTO medicoTO){
        MedicoTO resultado = medicoBO.save(medicoTO);
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
        MedicoTO resultado = medicoBO.findById(id);
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
        if(medicoBO.delete(id)){
            response = Response.status(204);
        }else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid MedicoTO medicoTO, @PathParam("id") Long id){;
        medicoTO.setIdMedico(id);
        Response.ResponseBuilder response = null;
        MedicoTO resultado = medicoBO.update(medicoTO);
        if(resultado != null){
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
