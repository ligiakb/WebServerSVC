/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leituras;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author ligia
 */

@XmlRootElement
public class Leitura {
    
private static Leitura INSTANCE = null;//restringe a instanciação a um único objeto

public static Leitura getInstance(){
    if (INSTANCE == null){
        INSTANCE = new Leitura();
        System.out.println("Criou singleton");
    }
    return INSTANCE;
}

//Ex.: private float temperature = (float)0.0; criar variavel que vai armazenar os ids enviaddos pelo leitor
private float temperature = (float)0.0;

private Leitura(){
    this.temperature = (float)0.0; //construtor inicia variavel com valor zero
}

public Leitura(float temperature){ //construtor armazena valor de temperatura
    this.temperature = temperature;
}

public void setValue (float temperature){
    this.temperature = temperature;
}

public float getValue(){
    return temperature;
}

public void convertToFahrenheit(){
    temperature = (float)1.8*temperature+32;
}//comparar com lista de itens base
}
