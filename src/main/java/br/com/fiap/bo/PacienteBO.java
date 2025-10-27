package br.com.fiap.bo;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.to.PacienteTO;

import java.util.ArrayList;

public class PacienteBO{
    //atributos
    private PacienteDAO pacienteDAO;
    //metodos particulares
    public ArrayList findAll(){
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.findAll();
    }
    public PacienteTO save(PacienteTO pacienteTO) {
        pacienteDAO = new PacienteDAO();
        if (pacienteTO.getCpf() == null || pacienteTO.getCpf().length() != 11){
            return null;
        }
        return pacienteDAO.save(pacienteTO);
    }
    public PacienteTO findById(Long id){
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.findById(id);
    }
    public boolean delete(Long id){
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.delete(id);
    }
    public PacienteTO update(PacienteTO pacienteTO) {
        pacienteDAO = new PacienteDAO();
        if (pacienteTO.getCpf() == null || pacienteTO.getCpf().length() != 11){
            return null;
        }
        return pacienteDAO.update(pacienteTO);
    }
}
