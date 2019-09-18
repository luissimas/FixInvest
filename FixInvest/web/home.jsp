<%-- 
    Document   : home
    Created on : Aug 30, 2019, 8:37:46 AM
    Author     : Padawan
--%>

<%@page import="Model.Escritor"%>
<%@page import="Model.Estudante"%>
<%@page import="javax.servlet.http.HttpSession;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FixInvest</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div align="left">
            <%
                HttpSession sessao = request.getSession();
                
                if(((Estudante) sessao.getAttribute("estudante")) != null){
                    out.println("<a href='perfilinvestidor.jsp'>Perfil de Investidor</a>");
                }
            %>
        </div>
        <div align="right">
            <form action="SListarArtigos" method="post">
                <input type="submit" name="btnEnviar" value="Investimentos"/>
                <input type="submit" name="btnEnviar" value="Teste"/>
            </form>
        </div>
        <div align="center">
            <h1>Em breve...</h1>
            <%                
                if(((Escritor) sessao.getAttribute("escritor")) != null){
                    out.println("<a href='incluirArtigos.html'>Incluir artigos</a>");
                }
            %>
            
        </div>
    </body>
</html>
