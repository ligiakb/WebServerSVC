/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerSVC;

import java.util.*;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import Leituras.*;
import Transaction.Transaction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
/**
 * REST Web Service
 *
 * @author ligia
 */
@ApplicationPath(" webresources")
@Path("controller")
public class LeituraController extends Application {

    private final static String LEITURA = "valor";
    
    
    Leitura leitura = Leitura.getInstance();
    
    @Context //permitem apenas a injeção de objetos dentro do nosso objeto do Controller
    UriInfo uriInfo;
    
    @Context
    Request request;
    
    @GET // Teste
    @Produces(MediaType.TEXT_PLAIN)
    public String statusService(){
        return "O servico esta em operacao";
    }
    
    @GET
    @Path("idslidos")
    @Produces(MediaType.APPLICATION_JSON)
    public Leitura getTemperature(){
        
        System.out.println("Pedido de conversao pelo app cliente: "+ leitura.getValue());
        //leitura.convertToFahrenheit();//nosso método
        
        return leitura;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Leitura postTemperature(String parameters){
        System.out.println("Dados recebidos");
        //remocao da parte escrita tagsPipe=, referente ao parametro do POST
        String tagsCorrigidas = parameters.substring(9);
        //Split das tags enviadas, que estao no formato tag1|tag2|tag3|...
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(tagsCorrigidas.split("%7C")));
        printList(myList);
        LeituraDAO dao = new LeituraDAO();
        //Instanciacao da transaction
        Transaction tr = new Transaction();
        
        try {
            //abertura da conexao
            tr.begin();
            //chama funcao de consulta na base de dados.
            //Ela busca pelo ID da tag do carro na tabela de carros e traz essa
            //lista pro controller.
            ArrayList<String> itensCarro = dao.buscarPorIdCarro("123", tr);
            ArrayList<String> itensFaltantes = new ArrayList<String>();
            //Variavel que sera utilizada para verificar quais itens existem nas
            //duas listas. Caso ele nao exista, eu adiciona
            int existe;
            for (String itemCarro : itensCarro) {
                existe = 0;
                for (String itemLido : myList){
                    System.out.println("itens comparados:");
                    System.out.println("itemCarro:" + itemCarro);
                    System.out.println("itemLido:" + itemLido);
                    if(Objects.equals(itemCarro,itemLido)){
                        existe = 1;
                    }
                }
                if(existe == 0){
                    itensFaltantes.add(itemCarro);
                }		
            }
            for (String itemFaltante : itensFaltantes){
                System.out.println(itemFaltante);
            }
            
            leitura.setValue(itensFaltantes);
            
            
        } catch (Exception ex) {
            Logger.getLogger(LeituraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return leitura;
    }
      
    public static void printList(ArrayList<String> myList){
        for(int i=0; i<myList.size();i++){
        System.out.println(myList.get(i));
       }
}  
    
}
    

    
   
    
    
   

