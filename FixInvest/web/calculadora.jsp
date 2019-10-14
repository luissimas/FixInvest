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

                                document.getElementById('idRendimento').value = investimento.rendimento;

                            }
                        }
                    };
                }
                ajax.send(null);
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
            Depósito inicial: <input type="text" name="txtDepositoInicial" id="idDepositoInicial" value="0"/></br>
            Depósito mensal: <input type="text" name="txtDepositoMensal" id="idDepositoMensal" value="0"/></br>
            Tempo investido: <input type="text" name="txtTempoInvestido" id="idTempoInvestido" value="0"/></br>
            Rendimento: <input type="text" name="txtRendimento" id="idRendimento" value="0" readonly="true"/></br>
        </div>
    </body>
</html>
