package br.com.fiap.dao;

import br.com.fiap.to.TelefonePacienteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelefonePacienteDAO{
    //metodos particulares
    public ArrayList<TelefonePacienteTO> findAll(){
        ArrayList<TelefonePacienteTO> telefonePacientes = new ArrayList<>();
        String sql = "select * from telefonepaciente order by idtelefone";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    TelefonePacienteTO telefonePacienteTO = new TelefonePacienteTO();
                    telefonePacienteTO.setIdTelefone(rs.getLong("idtelefone"));
                    telefonePacienteTO.setIdPaciente(rs.getLong("idpaciente"));
                    telefonePacienteTO.setDdd(rs.getInt("ddd"));
                    telefonePacienteTO.setNumero(rs.getInt("numero"));
                    telefonePacientes.add(telefonePacienteTO);
                }
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.printf("Erro ao consultar tabela: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return telefonePacientes;
    }

    public TelefonePacienteTO save(TelefonePacienteTO telefonePacienteTO){
        String sql = "insert into telefonepaciente (idPaciente, ddd, numero) values(?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, telefonePacienteTO.getIdPaciente());
            ps.setInt(2, telefonePacienteTO.getDdd());
            ps.setInt(3, telefonePacienteTO.getNumero());
            if (ps.executeUpdate() > 0) {
                return telefonePacienteTO;
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public TelefonePacienteTO findById(Long id){
        String sql = "select * from telefonepaciente where idtelefone = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                TelefonePacienteTO telefonePacienteTO = new TelefonePacienteTO();
                telefonePacienteTO.setIdTelefone(rs.getLong("idtelefone"));
                telefonePacienteTO.setIdPaciente(rs.getLong("idpaciente"));
                telefonePacienteTO.setDdd(rs.getInt("ddd"));
                telefonePacienteTO.setNumero(rs.getInt("numero"));
                return telefonePacienteTO;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao consultar um Telefone de um paciente da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id){
        String sql = "delete from telefonepaciente where idTelefone = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println("Erro ao deletar um telefone da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
    public TelefonePacienteTO update(TelefonePacienteTO telefonePacienteTO) {
        String sql = "update telefonepaciente set idpaciente = ?, ddd = ?, numero = ? where idtelefone = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, telefonePacienteTO.getIdPaciente());
            ps.setInt(2, telefonePacienteTO.getDdd());
            ps.setInt(3, telefonePacienteTO.getNumero());
            ps.setLong(4, telefonePacienteTO.getIdTelefone());
            if (ps.executeUpdate() > 0){
                return telefonePacienteTO;
            }else{
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar um telefone da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
