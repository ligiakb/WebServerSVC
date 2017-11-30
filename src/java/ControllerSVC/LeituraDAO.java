/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerSVC;


import Leituras.Leitura;
import java.sql.*;
import java.util.*;
import Transaction.Transaction;

/**
 *
 * @author ligia
 */
public class LeituraDAO {
    
public ArrayList<String> buscarPorIdCarro(String id, Transaction tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select id_tag from item_etiquetado where carro_idcarro = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        ArrayList<String> ids = new ArrayList<String>();
        while (rs.next()) {
            ItemTag itemtag = new ItemTag();
            itemtag.setIdTag(rs.getString("id_tag"));
            System.out.println(rs.getString("id_tag"));
            ids.add(itemtag.getIdTag());
        }
        
        return ids;
    } // buscar 


    
}
