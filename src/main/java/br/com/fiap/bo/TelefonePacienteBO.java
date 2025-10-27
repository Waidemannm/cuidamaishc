package br.com.fiap.bo;

import br.com.fiap.dao.TelefonePacienteDAO;
import br.com.fiap.to.TelefonePacienteTO;

import java.util.ArrayList;

public class TelefonePacienteBO{
    //atributos
    private TelefonePacienteDAO telefonePacienteDAO;
    //metodos particulares
    public ArrayList findAll(){
        telefonePacienteDAO = new TelefonePacienteDAO();
        return telefonePacienteDAO.findAll();
    }
    public TelefonePacienteTO save(TelefonePacienteTO telefonePacienteTO) {
        telefonePacienteDAO = new TelefonePacienteDAO();
        return telefonePacienteDAO.save(telefonePacienteTO);
    }
    public TelefonePacienteTO findById(Long id){
        telefonePacienteDAO = new TelefonePacienteDAO();
        return telefonePacienteDAO.findById(id);
    }
    public boolean delete(Long id){
        telefonePacienteDAO = new TelefonePacienteDAO();
        return telefonePacienteDAO.delete(id);
    }
    public TelefonePacienteTO update(TelefonePacienteTO telefonePacienteTO) {
        telefonePacienteDAO = new TelefonePacienteDAO();
        return telefonePacienteDAO.update(telefonePacienteTO);
    }
}

