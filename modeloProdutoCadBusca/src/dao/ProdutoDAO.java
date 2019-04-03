/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ProdutoVO;
import persistencia.ConexaoBanco;

/**
 * @author Thiago Cury
 * @since 07/04/2014 - 11:46
 * @version 1.0 beta
 */
public class ProdutoDAO {

    /**
     * @author Thiago Cury
     * @version 1.0 beta
     * @since 07/04/2014
     */
    public void cadastrarProduto(ProdutoVO pVO) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            sql = "insert into produto(id_produto,nome,valorcusto,quantidade)"
                    + "values(null, '" + pVO.getNome() + "', " + pVO.getValorCusto() + ", " + pVO.getQuantidade() + ")";

            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar produto! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public ArrayList<ProdutoVO> buscarProdutos() throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql = "";
            sql = "select * from produto";
            ArrayList<ProdutoVO> prods = new ArrayList<>();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                ProdutoVO p = new ProdutoVO();
                p.setIdProduto(rs.getLong("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setValorCusto(rs.getDouble("valorcusto"));
                prods.add(p);
            }
            return prods;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar produtos!" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public void deleterProduto(long id) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql = "";
            sql = "delete from produto where id_produto=" + id;
            stat.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro ao excluir produto!" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }//fecha delete

    public void alterarProduto(ProdutoVO p) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql = "";
            sql = "update produto set nome='" + p.getNome() + "', valorcusto=" + p.getValorCusto() + ", quantidade=" + p.getQuantidade() + " where id_produto=" + p.getIdProduto() + "";
            stat.executeUpdate(sql);
        } catch (Exception e) {
            throw new SQLDataException("Erro ao alterar o produto! " + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }//fecha update
    
    public ArrayList<ProdutoVO> filtrarProdutos(String pesquisa, String filtro) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
             String sql;
            sql = "select * from produto ";

            if (filtro.equalsIgnoreCase("Codigo")) {
                sql += "where id_produto=" + pesquisa;
            } else if (filtro.equalsIgnoreCase("Nome")) {
                sql += "where nome like '%" + pesquisa + "%'";
            } else if (filtro.equalsIgnoreCase("Valor custo")) {
                sql += "where valorcusto like '%" + pesquisa + "%'";
            } else if (filtro.equalsIgnoreCase("Quantidade")) {
                sql += "where quantidade like '%" + pesquisa + "%'";
            }

            ArrayList<ProdutoVO> prods = new ArrayList<>();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                ProdutoVO p = new ProdutoVO();
                p.setIdProduto(rs.getLong("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setValorCusto(rs.getDouble("valorcusto"));
                prods.add(p);
            }
            return prods;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar produtos!" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }
}//fecha classe
