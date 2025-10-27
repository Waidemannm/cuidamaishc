package br.com.fiap.dao;

import br.com.fiap.to.UnidadeHCTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnidadeHCDAO {
    //metodos particulares

    public ArrayList<UnidadeHCTO> findAll(){
        ArrayList<UnidadeHCTO> unidadesHC = new ArrayList<>();
        String sql = "select * from unidadehc order by nomeUnidade";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    UnidadeHCTO unidadeHCTO = new UnidadeHCTO();
                    unidadeHCTO.setIdUnidade(rs.getLong("idunidade"));
                    unidadeHCTO.setIdLogradouro(rs.getLong("idlogradouro"));
                    unidadeHCTO.setNomeUnidade(rs.getString("nomeunidade"));
                    unidadeHCTO.setDataFundacao(rs.getDate("datafundacao").toLocalDate());
                    unidadesHC.add(unidadeHCTO);
                }
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.printf("Erro ao consultar tabela: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return unidadesHC;
    }

    public UnidadeHCTO save(UnidadeHCTO unidadeHCTO){
        String sql = "insert into unidadehc (idLogradouro, nomeUnidade, dataFundacao) values(?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, unidadeHCTO.getIdLogradouro());
            ps.setString(2, unidadeHCTO.getNomeUnidade());
            ps.setDate(3, Date.valueOf(unidadeHCTO.getDataFundacao()));
            if (ps.executeUpdate() > 0) {
                return unidadeHCTO;
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

    public  UnidadeHCTO findById(Long id){
        String sql = "select * from unidadehc where idUnidade = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                UnidadeHCTO unidadeHCTO = new UnidadeHCTO();
                unidadeHCTO.setIdUnidade(rs.getLong("idunidade"));
                unidadeHCTO.setIdLogradouro(rs.getLong("idlogradouro"));
                unidadeHCTO.setNomeUnidade(rs.getString("nomeunidade"));
                unidadeHCTO.setDataFundacao(rs.getDate("datafundacao").toLocalDate());
                return unidadeHCTO;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao consultar uma unidade da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id){
        String sql = "delete from unidadehc where idunidade = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println("Erro ao deletar uma unidade da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public UnidadeHCTO update(UnidadeHCTO unidadeHCTO) {
        String sql = "update unidadehc set idlogradouro = ?, nomeunidade = ?, datafundacao = ? where idunidade = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, unidadeHCTO.getIdLogradouro());
            ps.setString(2, unidadeHCTO.getNomeUnidade());
            ps.setDate(3, Date.valueOf(unidadeHCTO.getDataFundacao()));
            ps.setLong(4, unidadeHCTO.getIdUnidade());
            if (ps.executeUpdate() > 0){
                return unidadeHCTO;
            }else{
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar uma unidade da tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
