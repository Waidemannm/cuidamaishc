package br.com.fiap.dao;

import br.com.fiap.to.ConsultaTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDAO {
    //metodos particulares
    public ArrayList<ConsultaTO> findAll(){
        ArrayList<ConsultaTO> consultas = new ArrayList<>();
        String sql = "select * from consulta order by dtconsulta";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    ConsultaTO consultaTO = new ConsultaTO();
                    consultaTO.setIdConsulta(rs.getLong("idconsulta"));
                    consultaTO.setIdUnidade(rs.getLong("idunidade"));
                    consultaTO.setIdPaciente(rs.getLong("idpaciente"));
                    consultaTO.setIdMedico(rs.getLong("idmedico"));
                    consultaTO.setDtConsulta(rs.getDate("dtconsulta").toLocalDate());
                    consultas.add(consultaTO);
                }
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.printf("Erro ao consultar tabela: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return consultas;
    }

    public ConsultaTO save(ConsultaTO consultaTO){
        String sql = "insert into consulta (idunidade, idpaciente, idmedico, dtconsulta) values(?, ?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, consultaTO.getIdUnidade());
            ps.setLong(2, consultaTO.getIdPaciente());
            ps.setLong(3, consultaTO.getIdMedico());
            ps.setDate(4, Date.valueOf(consultaTO.getDtConsulta()));
            if (ps.executeUpdate() > 0) {
                return consultaTO;
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

    public ConsultaTO findById(Long id){
        String sql = "select * from consulta where idconsulta = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ConsultaTO consultaTO = new ConsultaTO();
                consultaTO.setIdConsulta(rs.getLong("idconsulta"));
                consultaTO.setIdUnidade(rs.getLong("idunidade"));
                consultaTO.setIdPaciente(rs.getLong("idpaciente"));
                consultaTO.setIdMedico(rs.getLong("idmedico"));
                consultaTO.setDtConsulta(rs.getDate("dtconsulta").toLocalDate());
                return consultaTO;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao consultar uma consulta da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id){
        String sql = "delete from consulta where idconsulta = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println("Erro ao deletar uma consulta da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ConsultaTO update(ConsultaTO consultaTO) {
        String sql = "update consulta set idunidade = ?, idpaciente = ?, idmedico = ?, dtconsulta = ? where idconsulta = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, consultaTO.getIdUnidade());
            ps.setLong(2, consultaTO.getIdPaciente());
            ps.setLong(3, consultaTO.getIdMedico());
            ps.setDate(4, Date.valueOf(consultaTO.getDtConsulta()));
            ps.setLong(5, consultaTO.getIdConsulta());
            if (ps.executeUpdate() > 0){
                return consultaTO;
            }else{
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar uma consulta da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
