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

                if (((Estudante) sessao.getAttribute("estudante")).getPerfil() != null) {
                    out.println("<h2>Você é um investidor " + ((Estudante) sessao.getAttribute("estudante")).getPerfil() + "</h2></br>");
                    if (((Estudante) sessao.getAttribute("estudante")).getPerfil().equalsIgnoreCase("conservador")) {
                        out.println("Você prioriza segurança em suas aplicações. É recomendado que você mantenha a maior parte de seus investimentos em produtos de baixo "
                                + "risco, como por exemplo: Tesouro Direto, CDB, LC, LCI/LCA e Fundos de renda fixa.</br>");
                    } else if (((Estudante) sessao.getAttribute("estudante")).getPerfil().equalsIgnoreCase("moderado")) {
                        out.println("Você é um investidor versátil que valoriza a segurança mas opta por investimentos arriscados em determinadas ocasiões. É recomendado que você "
                                + "diversifique seus investimentos e busque equilibrar rentabilidade e risco.");
                    } else if (((Estudante) sessao.getAttribute("estudante")).getPerfil().equalsIgnoreCase("agressivo")) {
                        out.println("Você é um investidor mais experiente e preza pela rentabilidade. É recomendado que você mantenha uma parcela de seus investimento em produtos "
                                + "mais conservadores para criar um fundo de emergência. Apesar disso, a maior parte de seus invesitmentos deve ser alocada em produtos de renda variável");
                    }
                    out.println("<a href='formularioperfilInvestidor.html'>Refazer teste</a>");
                } else {
                    out.println("<h2>Você ainda não possui um perfil de investidor</h2></br>");
                    out.println("<a href='formularioperfilInvestidor.html'>Faça o teste!</a>");
                }
            %>
        </div>
    </body>
</html>
