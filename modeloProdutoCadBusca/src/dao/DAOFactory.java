/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 * @author Thiago Cury
 * @since 07/04/2014 - 11:46
 * @version 1.0 beta
 */
public class DAOFactory {
    
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public static ProdutoDAO getProdutoDAO(){
        return produtoDAO;
    }//fecha método
    
}//fecha classe
