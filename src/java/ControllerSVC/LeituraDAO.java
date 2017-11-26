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
    
public List<String> buscarPorIdCarro(String id, Transaction tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select id_tag_item from item_etiquetado where carro_idcarro = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        ArrayList<String> ids = new ArrayList<String>();
        while (rs.next()) {
            ItemTag itemtag = new ItemTag();
            itemtag.setIdTag(rs.getString("ID"));
            ids.add(itemtag.toString());
        }
        return ids;
    } // buscar   
    
}
