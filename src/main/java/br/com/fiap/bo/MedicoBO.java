package br.com.fiap.bo;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.to.MedicoTO;

import java.util.ArrayList;

public class MedicoBO {
    //atributos
    private MedicoDAO medicoDAO;
    //metodos particulares
    public ArrayList findAll(){
        medicoDAO = new MedicoDAO();
        return medicoDAO.findAll();
    }
    public MedicoTO save(MedicoTO medicoTO) {
        medicoDAO = new MedicoDAO();
        if (medicoTO.getCpf() == null || medicoTO.getCpf().length() != 11){
            return null;
        }
        MedicoTO existente = medicoDAO.findByCpf(medicoTO.getCpf());
        if (existente != null) {
            // Retorna null ou lança exceção (opcional)
            System.out.println("CPF já cadastrado: " + medicoTO.getCpf());
            return null;
        }
        return medicoDAO.save(medicoTO);
    }
    public MedicoTO findById(Long id){
        medicoDAO = new MedicoDAO();
        return medicoDAO.findById(id);
    }
    public boolean delete(Long id){
        medicoDAO = new MedicoDAO();
        return medicoDAO.delete(id);
    }
    public MedicoTO update(MedicoTO medicoTO) {
        medicoDAO = new MedicoDAO();
        if (medicoTO.getCpf() == null || medicoTO.getCpf().length() != 11){
            return null;
        }
        MedicoTO existente = medicoDAO.findByCpf(medicoTO.getCpf());
        if (existente != null) {
            // Retorna null ou lança exceção (opcional)
            System.out.println("CPF já cadastrado: " + medicoTO.getCpf());
            return null;
        }
        return medicoDAO.update(medicoTO);
    }
}
