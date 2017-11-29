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
        String temperatureInternal = parameters;
        leitura.setValue(temperatureInternal);
        System.out.println("Dados recebidos");
        String tagsCorrigidas = parameters.substring(9);
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(tagsCorrigidas.split("%7C")));
        printList(myList);
        LeituraDAO dao = new LeituraDAO();
        Transaction tr = new Transaction();
        
        try {
            tr.begin();
            ArrayList<String> itensCarro = dao.buscarPorIdCarro("123", tr);
            //comparar listascomparaListas()
            //obter lista de ids faltantes
            //página que vai exibir o resultado deve fazer a solicitação para o WebServer
            
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
    

    
   
    
    
   

