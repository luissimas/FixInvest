/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ArtigoCRUD;
import Model.Artigo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Padawan
 */
@WebServlet(name = "SListarArtigos", urlPatterns = {"/SListarArtigos"})
public class SListarArtigos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Artigo artigo = new Artigo();
        ArtigoCRUD artigoCRUD = new ArtigoCRUD();
        ResultSet tabela;
        int coluna = 0;

        try {
            tabela = artigoCRUD.listar(request.getParameter("btnEnviar"));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Artigos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            if (tabela.next() != false) {
                out.println("<h1>Artigos na categoria " + request.getParameter("btnEnviar") + ".</h1>");
                out.println("<table border='1'> <tbody> <tr>"); //Começa uma nova linha

                out.println("<td>"); //Início da coluna
                    out.println(
                            "<form action='SControlador' method='post' >"
                            + "<input type='text' hidden name='txtCodigo' value='" + tabela.getInt(1) + "'/>"
                            + "<h1>" + tabela.getString(3) + "</h1><br/>");
                    if (tabela.getString(4).length() > 10) {
                        out.println("<h4>" + tabela.getString(4).substring(0, 10) + "</h4>");
                    } else {
                        out.println("<h4>" + tabela.getString(4) + "</h4>");
                    }
                    out.println("<input type='submit' name='btnEnviar' value='Ver artigo'/>"
                            + "</form>"
                    );
                    out.println("</td>"); //Fim da coluna

                while (tabela.next()) {
                    out.println("<td>"); //Início da coluna
                    out.println(
                            "<form action='SControlador' method='post' >"
                            + "<input type='text' hidden name='txtCodigo' value='" + tabela.getInt(1) + "'/>"
                            + "<h1>" + tabela.getString(3) + "</h1><br/>");
                    if (tabela.getString(4).length() > 10) {
                        out.println("<h4>" + tabela.getString(4).substring(0, 10) + "</h4>");
                    } else {
                        out.println("<h4>" + tabela.getString(4) + "</h4>");
                    }
                    out.println("<input type='submit' name='btnEnviar' value='Ver artigo'/>"
                            + "</form>"
                    );
                    out.println("</td>"); //Fim da coluna 

                    coluna++;

                    if (coluna == 3) { //Define quantos artigos por linha
                        out.print("</tr><tr>"); //Fecha a linha e começa outra
                        coluna = 0;
                    }
                }
                out.println("</tr></tbody></table>"); // fecha a ultima linha
            } else {
                out.println("<h1>Não há artigos na categoria " + request.getParameter("btnEnviar") + ".</h1>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Erro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
