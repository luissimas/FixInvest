/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ArtigoCRUD;
import Controller.EscritorCRUD;
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
@WebServlet(name = "SExibirArtigo", urlPatterns = {"/SExibirArtigo"})
public class SExibirArtigo extends HttpServlet {

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
        EscritorCRUD escritorCRUD = new EscritorCRUD();
        ResultSet tabela;

        try {
            tabela = artigoCRUD.listarCodigo(Integer.parseInt(request.getParameter("txtCodigo")));
            tabela.next();

            artigo.setCodigo(tabela.getInt(1));
            artigo.setCategoria(tabela.getString(2));
            artigo.setTitulo(tabela.getString(3));
            artigo.setTexto(tabela.getString(4));
            artigo.setData(tabela.getDate(5).toString());
            artigo.setCodEscritor(tabela.getInt(6));

            tabela = escritorCRUD.listarCodigo(artigo.getCodEscritor());
            tabela.next();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + artigo.getTitulo() + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");

            out.println("<h1>" + artigo.getTitulo() + "</h1></br>");
            out.println("<h4>" + tabela.getString(2) + "; Data de publicação: " + artigo.getData() + "</h4></br>");
            out.println(artigo.getTexto());

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
