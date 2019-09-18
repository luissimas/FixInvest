<%-- 
    Document   : perfilinvestidor
    Created on : Sep 18, 2019, 7:21:15 PM
    Author     : Padawan
--%>

<%@page import="Model.Estudante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de investidor</title>
    </head>
    <body>
        <div align="center">
            <%
                HttpSession sessao = request.getSession();
                
                if(((Estudante) sessao.getAttribute("estudante")).getPerfil() != null){
                    out.println("<h2>Você é um investidor " + ((Estudante) sessao.getAttribute("estudante")).getPerfil() + "</h2></br>");
                    out.println("<a href='formularioperfilInvestidor.html'>Refazer teste</a>");
                }else{
                    out.println("<h2>Você ainda não possui um perfil de investidor</h2></br>");
                    out.println("<a href='formularioperfilInvestidor.html'>Faça o teste!</a>");
                }
            %>
        </div>
    </body>
</html>
