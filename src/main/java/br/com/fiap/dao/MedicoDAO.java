package br.com.fiap.dao;

import br.com.fiap.to.MedicoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDAO{
    //metodos particulares
    public ArrayList<MedicoTO> findAll(){
        ArrayList<MedicoTO> medicos = new ArrayList<>();
        String sql = "select * from medico order by nome";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    MedicoTO medicoTO = new MedicoTO();
                    medicoTO.setIdMedico(rs.getLong("idmedico"));
                    medicoTO.setCrm(rs.getInt("crm"));
                    medicoTO.setEspecialidade(rs.getString("especialidade"));
                    medicoTO.setNome(rs.getString("nome"));
                    medicoTO.setDataNascimento(rs.getDate("datanascimento").toLocalDate());
                    medicoTO.setCpf(rs.getString("cpf"));
                    medicos.add(medicoTO);
                }
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.printf("Erro ao consultar tabela: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return medicos;
    }
    public MedicoTO save(MedicoTO medicoTO){
        String sql = "insert into medico (crm, especialidade, nome, datanascimento, cpf) values(?, ?, ?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, medicoTO.getCrm());
            ps.setString(2, medicoTO.getEspecialidade());
            ps.setString(3, medicoTO.getNome());
            ps.setDate(4, Date.valueOf(medicoTO.getDataNascimento()));
            ps.setString(5, medicoTO.getCpf());
            if (ps.executeUpdate() > 0) {
                return medicoTO;
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

    public MedicoTO findById(Long id){
        String sql = "select * from medico where idmedico = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                MedicoTO medicoTO = new MedicoTO();
                medicoTO.setIdMedico(rs.getLong("idmedico"));
                medicoTO.setCrm(rs.getInt("crm"));
                medicoTO.setEspecialidade(rs.getString("especialidade"));
                medicoTO.setNome(rs.getString("nome"));
                medicoTO.setDataNascimento(rs.getDate("datanascimento").toLocalDate());
                return medicoTO;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao consultar um Médico da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
    public boolean delete(Long id){
        String sql = "delete from medico where idmedico = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println("Erro ao deletar um médico da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
    public MedicoTO update(MedicoTO medicoTO) {
        String sql = "update medico set crm = ?, especialidade = ?, nome = ?, datanascimento = ?, cpf = ? where idmedico = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, medicoTO.getCrm());
            ps.setString(2, medicoTO.getEspecialidade());
            ps.setString(3, medicoTO.getNome());
            ps.setDate(4, Date.valueOf(medicoTO.getDataNascimento()));
            ps.setString(5, medicoTO.getCpf());
            ps.setLong(6, medicoTO.getIdMedico());
            if (ps.executeUpdate() > 0){
                return medicoTO;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar um médico da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
