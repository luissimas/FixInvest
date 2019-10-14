<%-- 
    Document   : calculadora
    Created on : Oct 13, 2019, 4:10:50 PM
    Author     : Padawan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Controller.InvestimentoCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    InvestimentoCRUD investimentoCRUD = new InvestimentoCRUD();
    ResultSet tabela;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>

        <script type="text/javascript">
            function preencher(codigoInvestimento)
            {
                var ajax = false;

                if (window.XMLHttpRequest)
                { // Mozilla, Safari, ... 
                    ajax = new XMLHttpRequest( );
                } else if (window.ActiveXObject)
                {// IE 
                    ajax = new ActiveXObject("Microsoft.XMLHTTP");
                }
                if (ajax)
                {
                    ajax.open("GET", "SCalculadora?codigo=" + codigoInvestimento, true);
                    ajax.onreadystatechange = function () {
                        if (ajax.readyState == 4)
                        {
                            if (ajax.status == 200)
                            {
                                var investimento;
                                try {
                                    investimento = JSON.parse(ajax.responseText);
                                } catch (e) {
                                    investimento = eval('(' + ajax.responseText + ')');
                                }

                                document.getElementById('idRentabilidade').value = investimento.rentabilidade;
                                        
                                calcular();
                            }
                        }
                    };
                }
                ajax.send(null);
            }
            
            function calcular(){
                var depositoInicial = parseFloat(document.getElementById('idDepositoInicial').value);
                var tempoInvestido = parseInt(document.getElementById('idTempoInvestido').value);
                var rentabilidade = parseFloat(document.getElementById('idRentabilidade').value / 100);
                var rendimentoBruto = 0.0;
                var rendimentoLiquido = 0.0;
                var ir = 0.0;
                
                if(tempoInvestido < 6){
                    ir = 0.225;
                }else if((tempoInvestido <= 12) || (tempoInvestido >= 6)){
                    ir = 0.2;
                }else if((tempoInvestido < 12) || (tempoInvestido >= 24)){
                    ir = 0.175;
                }else if(tempoInvestido > 24){
                    ir = 0.15;
                }
                
                rendimentoBruto = depositoInicial * (rentabilidade * (tempoInvestido / 12));
                rendimentoLiquido = rendimentoBruto - (rendimentoBruto * ir);
                
                document.getElementById('idValorFinalBruto').value = depositoInicial + rendimentoBruto;
                document.getElementById('idValorFinalLiquido').value = depositoInicial + rendimentoLiquido;
            }
        </script>
    </head>
    <body>
        <div align="center">
            <h1>Calculadora de investimentos</h1>
            Investimento: <select name="cmbProduto" id="idInvestimentos" onchange="preencher(this.value)">
                <%
                    tabela = investimentoCRUD.listar();

                    while (tabela.next()) {
                        out.println("<option value='" + tabela.getInt(1) + "'>" + tabela.getString(2) + "</option>");
                    }
                %>
            </select>
            </br>
            Depósito inicial: <input type="text" name="txtDepositoInicial" id="idDepositoInicial" value="0" onchange="calcular()"/></br>
            Tempo investido: <input type="text" name="txtTempoInvestido" id="idTempoInvestido" value="0" onchange="calcular()"/></br>
            Rentabilidade: <input type="text" name="txtRentabilidade" id="idRentabilidade" value="0" readonly="true"/>% a.a</br>
            Valor bruto: <input type="text" name="txtValorFinalBruto" id="idValorFinalBruto" value="0" readonly="true"/></br>
            Valor líquido: <input type="text" name="txtValorFinalLiquido" id="idValorFinalLiquido" value="0" readonly="true"/></br>
            O valor líquido é o valor final do investimento, ou seja, descontado o imposto de renda.
        </div>
    </body>
</html>
