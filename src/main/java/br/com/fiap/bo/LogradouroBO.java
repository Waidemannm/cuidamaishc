package br.com.fiap.bo;

import br.com.fiap.dao.LogradouroDAO;
import br.com.fiap.to.LogradouroTO;

import java.util.ArrayList;
import java.util.Arrays;

public class LogradouroBO {
    //atributos
    private LogradouroDAO logradouroDAO;
    //metodos particulares
    public ArrayList findAll(){
        logradouroDAO = new LogradouroDAO();
        return logradouroDAO.findAll();
    }
    public LogradouroTO save(LogradouroTO logradouroTO) {
        logradouroDAO = new LogradouroDAO();
        //regra de negocios para sgestados
        ArrayList<String> sgEstados = new ArrayList<>(Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));
        if(!sgEstados.contains(logradouroTO.getSgEstado().toUpperCase().trim())){
            return null;
        }
        return logradouroDAO.save(logradouroTO);
    }
    public LogradouroTO findById(Long id){
        logradouroDAO = new LogradouroDAO();
        return logradouroDAO.findById(id);
    }
    public boolean delete(Long id){
        logradouroDAO = new LogradouroDAO();
        return logradouroDAO.delete(id);
    }
    public LogradouroTO update(LogradouroTO logradouroTO) {
        logradouroDAO = new LogradouroDAO();
        //regra de negocios para sgestados
        ArrayList<String> sgEstados = new ArrayList<>(Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));
        if(!sgEstados.contains(logradouroTO.getSgEstado().toUpperCase().trim())){
            return null;
        }
        return logradouroDAO.update(logradouroTO);
    }
}
