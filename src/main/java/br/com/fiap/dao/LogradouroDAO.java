package br.com.fiap.dao;
import br.com.fiap.to.LogradouroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogradouroDAO{
    //metodos particulares
    public ArrayList<LogradouroTO> findAll(){
        ArrayList<LogradouroTO> logradouros = new ArrayList<>();
        String sql = "select * from logradouro order by nomelogradouro";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    LogradouroTO logradouroTO = new LogradouroTO();
                    logradouroTO.setIdLogradouro(rs.getLong("idlogradouro"));
                    logradouroTO.setNomeLogradouro(rs.getString("nomelogradouro"));
                    logradouroTO.setNumero(rs.getInt("numero"));
                    logradouroTO.setCep(rs.getString("cep"));
                    logradouroTO.setBairro(rs.getString("bairro"));
                    logradouroTO.setCidade(rs.getString("cidade"));
                    logradouroTO.setSgEstado(rs.getString("sgestado"));
                    logradouros.add(logradouroTO);
                }
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.printf("Erro ao consultar tabela: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return logradouros;
    }

    public LogradouroTO save(LogradouroTO logradouroTO){
        String sql = "insert into logradouro (nomelogradouro, numero, cep, bairro, cidade, sgestado) values(?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, logradouroTO.getNomeLogradouro());
            ps.setInt(2, logradouroTO.getNumero());
            ps.setString(3, logradouroTO.getCep());
            ps.setString(4, logradouroTO.getBairro());
            ps.setString(5, logradouroTO.getCidade());
            ps.setString(6, logradouroTO.getSgEstado());
            if (ps.executeUpdate() > 0) {
                return logradouroTO;
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

    public LogradouroTO findById(Long id){
        String sql = "select * from logradouro where idlogradouro = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                LogradouroTO logradouroTO = new LogradouroTO();
                logradouroTO.setIdLogradouro(rs.getLong("idlogradouro"));
                logradouroTO.setNomeLogradouro(rs.getString("nomelogradouro"));
                logradouroTO.setNumero(rs.getInt("numero"));
                logradouroTO.setCep(rs.getString("cep"));
                logradouroTO.setBairro(rs.getString("bairro"));
                logradouroTO.setCidade(rs.getString("cidade"));
                logradouroTO.setSgEstado(rs.getString("sgestado"));
                return logradouroTO;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao consultar um logradouro da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id){
        String sql = "delete from logradouro where idlogradouro = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println("Erro ao deletar um logradouro da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public LogradouroTO update(LogradouroTO logradouroTO) {
        String sql = "update logradouro set nomelogradouro = ?, numero = ?, cep = ?, bairro = ?, cidade = ?, sgestado = ? where idlogradouro = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, logradouroTO.getNomeLogradouro());
            ps.setInt(2, logradouroTO.getNumero());
            ps.setString(3, logradouroTO.getCep());
            ps.setString(4, logradouroTO.getBairro());
            ps.setString(5, logradouroTO.getCidade());
            ps.setString(6, logradouroTO.getSgEstado());
            ps.setLong(7, logradouroTO.getIdLogradouro());
            if (ps.executeUpdate() > 0){
                return logradouroTO;
            }else{
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar um logradouro da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
