/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerSVC;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import Leituras.*;
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

    private final static String TEMPERATURE = "valor";
    
    Leitura temperature = Leitura.getInstance();
    
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
        
        System.out.println("Pedido de conversao pelo app cliente: "+ temperature.getValue());
        temperature.convertToFahrenheit();
        
        return temperature;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Leitura postTemperature(MultivaluedMap<String, String> parameters){
        float temperatureInternal = Float.parseFloat(parameters.getFirst(TEMPERATURE));
        temperature.setValue(temperatureInternal);
        
        System.out.println("Dados recebidos");
        
        return temperature;
    }
}
