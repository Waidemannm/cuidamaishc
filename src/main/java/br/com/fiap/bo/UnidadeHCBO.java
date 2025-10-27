package br.com.fiap.bo;

import br.com.fiap.dao.UnidadeHCDAO;
import br.com.fiap.to.UnidadeHCTO;

import java.util.ArrayList;

public class UnidadeHCBO {
    //atributos
    private UnidadeHCDAO unidadeHCDAO;
    //metodos particulares
    public ArrayList findAll(){
        unidadeHCDAO = new UnidadeHCDAO();
        return unidadeHCDAO.findAll();
    }
    public UnidadeHCTO save(UnidadeHCTO unidadeHCTO) {
        unidadeHCDAO = new UnidadeHCDAO();
        return unidadeHCDAO.save(unidadeHCTO);
    }
    public UnidadeHCTO findById(Long id){
        unidadeHCDAO = new UnidadeHCDAO();
        return unidadeHCDAO.findById(id);
    }
    public boolean delete(Long id){
        unidadeHCDAO = new UnidadeHCDAO();
        return unidadeHCDAO.delete(id);
    }
    public UnidadeHCTO update(UnidadeHCTO unidadeHCTO) {
        unidadeHCDAO = new UnidadeHCDAO();
        return unidadeHCDAO.update(unidadeHCTO);
    }
}
