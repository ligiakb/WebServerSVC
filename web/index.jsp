<%-- 
    Document   : conferenciaCarro
    Created on : 13/10/2017, 16:07:25
    Author     : Natalia
--%>


<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
    <title>Verificação de Carros de Emergência</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
        crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheets/font-awesome.css">
    <link rel="stylesheet" href="stylesheets/styles.css">
</head>

<header class="navbar fixed-top navbar-light tgi-header">
    <h1>Verificação de Carros de Emergência</h1>
</header>
<!-- See bootstrap documentation for navbar positioning options. All classes used here are bootstrap defaults, with the exception of the ones starting with prefix 'tgi-' -->
<nav class="navbar fixed-top navbar-dark bg-dark tgi-nav">
    <ul class="nav">
        <li class="nav-item">
            <i class="fa fa-user"></i>
            Maria (Enfermagem)
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="#">Notificações</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Conferir carro</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Consultar carros</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Sair</a>
        </li>
    </ul>
</nav>

  <main class="tgi-main">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-10">
                <br/><br/>
                <h3>Conferir carro</h3>
                </br>
                <h4>Para iniciar a leitura do carro, selecione a opção <b>START</b> no aplicativo do leitor.</h4>
                <h4>Após finalizar a leitura, aperte o botão <b>STOP</b> no aplicativo do leitor.</h4>
                <h4>Para concluir a leitura e ativar a integração das informações, clique no botão 
                    <form class="form-inline" action="./index.jsp" method="get" accept-charset="UTF-8">
                        <button type="submit" class="btn btn-primary btn-sm" name="finalizar" id="finalizar" value="finalizar">FINALIZAR</button>
                    </form>
                </h4>
                <!--Importando paginas e bibliotecas necessarias-->
                <%@ page import= "ControllerSVC.LeituraController"%>
                <%@ page import= "Leituras.Leitura"%>
                <%@ page import= "Transaction.Transaction"%>
                <%@page import="java.util.ArrayList"%>
                
                <%
                    //Caso o cliente tenha clicado no botao FINALIZAR, entra no if abaixo
                if ( null != request.getParameterValues("finalizar")){
                    //Pega a instancia do objeto de leitura
                    Leitura leitura = Leitura.getInstance();
                    
                    //pega os valores que existem no objeto de leitura
                    //Transaction tr = new Transaction();
                   // LeituraDAO dao = new LeituraDAO();
                    ArrayList<String> listaFaltante = leitura.getValue();
                    ArrayList<String> desc = leitura.nomes;
                    
                    %>Itens faltantes:<%
                    //itera pela lista de itens, e imprime
                    for (int i=0; i<listaFaltante.size();i++){
                        System.out.println(listaFaltante.get(i));
                        System.out.println(desc.get(i));
                        String id = listaFaltante.get(i);
                        String nome = desc.get(i);
                        %>
                        <%=id%>&nbsp<%=nome%>
                        <br/>               
                             
                    
                    <%}
                }
                %>
                <!--<table class="table table-sm">
                    <thead>
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID carro</th>
                    <th scope="col">Unidade</th>
                    <th scope="col">Data da última conferência</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                    <th scope="row">1</th>
                    <td>92759574</td>
                    <td>Maternidade</td>
                    <td>07/11/2017</td>
                    <td>Incompleto</td>
                    <td><button type="button" class="btn btn-primary btn-sm">Detalhes</button></td>
                    </tr>
                    <tr>
                    <th scope="row">2</th>
                    <td>28563038</td>
                    <td>Ambulatório</td>
                    <td>17/11/2017</td>
                    <td>Incompleto</td>
                    <td><button type="button" class="btn btn-primary btn-sm">Detalhes</button></td>
                    </tr>
                    <tr>
                    <th scope="row">3</th>
                    <td>19473938</td>
                    <td>UTI-Adulto</td>
                    <td>20/11/2017</td>
                    <td>Incompleto</td>
                    <td><button type="button" class="btn btn-primary btn-sm">Detalhes</button></td>
                    </tr>
                    </tbody>
                    </table>-->
                
                <!--<div class="row justify-content-center">
                    <div class="form-group col-md-6">
                    <input type="text" class="form-control" id="tag_carro">
                    </div>
                    <div class="form-group col-md-2">
                    <button type="button" class="btn btn-primary btn-sm">OK</button>
                    </div>
                </div>
                
                <div>
                    <h4>ID carro: 12425847</h4>
                    <h4>Unidade: Semi-intensiva Adulto</h4>
                </div>
                <div class="row justify-content-center">
                    <div class="col-4"><button type="button" class="btn btn-primary btn-sm">Confirmar carro</button></div>
                </div>
                
                <div class="row justify-content-center">
                    <div class="col-4"><button type="button" class="btn btn-secondary btn-sm">Tela inicial</button></div>
                </div>-->
                             
            </div>
        </div>
    </div>
</main>

</html>