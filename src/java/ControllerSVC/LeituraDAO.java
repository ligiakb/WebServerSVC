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
        //Mudar idcarro para id_tagcarro
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

//Obtem id do item generico correspondente à tag
public int obterIdItemGen (String id, Transaction tr) throws Exception {
        Connection con = tr.obterConexao();
        //Mudar idcarro para id_tagcarro
        String sql = "select id_item_generico from item_etiquetado where id_tag = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();       
        System.out.println(rs.getInt("id_item_generico"));
              
        return rs.getInt("id_item_generico");
    } // buscar

public int obterIdTipoItem (int id, Transaction tr) throws Exception {
        Connection con = tr.obterConexao();
        //Mudar idcarro para id_tagcarro
        String sql = "select id_tipo_item from item_generico where iditem_generico = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();       
        System.out.println(rs.getInt("id_tipo_item"));
              
        return rs.getInt("id_tipo_item");
    } // buscar

public String descricaoItem(int id, Transaction tr) throws Exception {
        Connection con = tr.obterConexao();
        //Mudar idcarro para id_tagcarro
        String sql = "select nome from tipo_item where idtipo_item = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();  
        String nome = rs.getString("nome");
        
       
        System.out.println(rs.getString("nome"));
           
        return nome;
    } // obter descrição do item 


    
}
