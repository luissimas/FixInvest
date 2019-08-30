/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EscritorCRUD;
import Controller.EstudanteCRUD;
import Model.Escritor;
import Model.Estudante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Padawan
 */
@WebServlet(name = "SCadastrar", urlPatterns = {"/SCadastrar"})
public class SCadastrar extends HttpServlet {

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

        if (request.getParameter("Tipo").trim().equalsIgnoreCase("Estudante")) {
            EstudanteCRUD estudanteCrud = new EstudanteCRUD();
            Estudante estudante = new Estudante();

            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cadastrar Estudante</title>");
                out.println("</head>");
                out.println("<body>");

                estudante.setNome(request.getParameter("txtNome"));
                estudante.setSenha(request.getParameter("txtSenha"));
                estudante.setEmail(request.getParameter("txtEmail"));
                estudante.setDataNasc(request.getParameter("dtpDataNasc"));

                estudanteCrud.gravar(estudante);

                out.println("<h1>Estudante " + estudante.getNome() + " cadastrado com sucesso!</h1>");

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
        } else if (request.getParameter("Tipo").trim().equalsIgnoreCase("Escritor")) {
            EscritorCRUD escritorCrud = new EscritorCRUD();
            Escritor escritor = new Escritor();

            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cadastrar Escritor</title>");
                out.println("</head>");
                out.println("<body>");

                escritor.setNome(request.getParameter("txtNome"));
                escritor.setSenha(request.getParameter("txtSenha"));
                escritor.setEmail(request.getParameter("txtEmail"));
                escritor.setDataNasc(request.getParameter("dtpDataNasc"));

                escritorCrud.gravar(escritor);

                out.println("<h1>Escritor " + escritor.getNome() + " cadastrado com sucesso!</h1>");
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
