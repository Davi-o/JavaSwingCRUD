/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicos;

import dao.DAOFactory;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ProdutoVO;

/**
 * @author Thiago Cury
 * @since 07/04/2014 - 11:46
 * @version 1.0 beta
 */
public class ProdutoServicos {
    public void cadastrarProduto(ProdutoVO pVO) throws SQLException{
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        pDAO.cadastrarProduto(pVO);

    }//fecha método
    public ArrayList<ProdutoVO> buscarProdutos() throws SQLException{
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        return pDAO.buscarProdutos();
    }//fecha método
    public void deletarProduto(long id)throws SQLException{
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        pDAO.deleterProduto(id);
    }//fecha método
    public void alterarProduto(ProdutoVO p)throws SQLException{
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        pDAO.alterarProduto(p);
    }//fecha o método
    public ArrayList<ProdutoVO> filtrar(String pesq, String filtro) throws SQLException {
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        return pDAO.filtrarProdutos(pesq, filtro);
    }//fecha método
    
}//fecha classe
