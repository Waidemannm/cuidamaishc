package br.com.fiap.dao;

import br.com.fiap.to.PacienteTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAO {
    //metodos particulares
    public ArrayList<PacienteTO> findAll(){
        ArrayList<PacienteTO> pacientes = new ArrayList<>();
        String sql = "select * from paciente order by nome";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    PacienteTO pacienteTO = new PacienteTO();
                    pacienteTO.setIdPaciente(rs.getLong("idpaciente"));
                    pacienteTO.setIdLogradouro(rs.getLong("idlogradouro"));
                    pacienteTO.setNome(rs.getString("nome"));
                    pacienteTO.setDataNascimento(rs.getDate("datanascimento").toLocalDate());
                    pacienteTO.setCpf(rs.getString("cpf"));
                    pacienteTO.setSenha(rs.getString("senha"));
                    pacientes.add(pacienteTO);
                }
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.printf("Erro ao consultar tabela: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return pacientes;
    }

    public PacienteTO save(PacienteTO pacienteTO){
        String sql = "insert into paciente (idlogradouro, nome, datanascimento, cpf, senha) values(?, ?, ?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            if (pacienteTO.getIdLogradouro() != null) {
                ps.setLong(1, pacienteTO.getIdLogradouro());
            } else {
                ps.setNull(1, java.sql.Types.BIGINT);
            }
            ps.setString(2, pacienteTO.getNome());
            ps.setDate(3, Date.valueOf(pacienteTO.getDataNascimento()));
            ps.setString(4, pacienteTO.getCpf());
            ps.setString(5, pacienteTO.getSenha());
            if (ps.executeUpdate() > 0) {
                return pacienteTO;
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

    public PacienteTO findById(Long id){
        String sql = "select * from paciente where idpaciente = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                PacienteTO pacienteTO = new PacienteTO();
                pacienteTO.setIdPaciente(rs.getLong("idpaciente"));
                pacienteTO.setIdLogradouro(rs.getLong("idlogradouro"));
                pacienteTO.setNome(rs.getString("nome"));
                pacienteTO.setDataNascimento(rs.getDate("datanascimento").toLocalDate());
                pacienteTO.setCpf(rs.getString("cpf"));
                pacienteTO.setSenha(rs.getString("senha"));
                return pacienteTO;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao consultar um paciente de um paciente da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
    public boolean delete(Long id){
        String sql = "delete from paciente where idpaciente = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println("Erro ao deletar um paciente da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public PacienteTO update(PacienteTO pacienteTO) {
        String sql = "update paciente set idlogradouro = ?, nome = ?, datanascimento = ?, cpf = ?, senha = ? where idpaciente = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            if (pacienteTO.getIdLogradouro() != null) {
                ps.setLong(1, pacienteTO.getIdLogradouro());
            } else {
                ps.setNull(1, java.sql.Types.BIGINT);
            }
            ps.setString(2, pacienteTO.getNome());
            ps.setDate(3, Date.valueOf(pacienteTO.getDataNascimento()));
            ps.setString(4, pacienteTO.getCpf());
            ps.setString(5, pacienteTO.getSenha());
            ps.setLong(6, pacienteTO.getIdPaciente());
            if (ps.executeUpdate() > 0){
                return pacienteTO;
            }else{
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar um paciente da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
    public PacienteTO findByCpf(String cpf) {
        String sql = "select * from paciente where cpf= ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PacienteTO pacienteTO = new PacienteTO();
                pacienteTO.setIdPaciente(rs.getLong("idpaciente"));
                pacienteTO.setIdLogradouro(rs.getLong("idlogradouro"));
                pacienteTO.setNome(rs.getString("nome"));
                pacienteTO.setDataNascimento(rs.getDate("datanascimento").toLocalDate());
                pacienteTO.setCpf(rs.getString("cpf"));
                pacienteTO.setSenha(rs.getString("senha"));
                return pacienteTO;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
