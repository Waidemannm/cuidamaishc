package br.com.fiap.bo;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.to.ConsultaTO;

import java.util.ArrayList;

public class ConsultaBO {
    //atributos
    private ConsultaDAO consultaDAO;
    //metodos particulares
    public ArrayList findAll(){
        consultaDAO = new ConsultaDAO();
        return consultaDAO.findAll();
    }
    public ConsultaTO save(ConsultaTO consultaTO) {
        consultaDAO = new ConsultaDAO();
        return consultaDAO.save(consultaTO);
    }
    public ConsultaTO findById(Long id){
        consultaDAO = new ConsultaDAO();
        return consultaDAO.findById(id);
    }
    public boolean delete(Long id){
        consultaDAO = new ConsultaDAO();
        return consultaDAO.delete(id);
    }
    public ConsultaTO update(ConsultaTO consultaTO) {
        consultaDAO = new ConsultaDAO();
        return consultaDAO.update(consultaTO);
    }
}
