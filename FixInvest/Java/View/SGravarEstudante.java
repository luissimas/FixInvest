/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.EstudanteCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Estudante;

/**
 *
 * @author Luís
 */
@WebServlet(name = "SGravarEstudante", urlPatterns = {"/SGravarEstudante"})
public class SGravarEstudante extends HttpServlet {

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

        EstudanteCRUD estudanteCrud = new EstudanteCRUD();
        Estudante estudante = new Estudante();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cadastrar</title>");
            out.println("</head>");
            out.println("<body>");
            if ((request.getParameter("txtSenha").trim().equals(request.getParameter("txtConfirmarSenha").trim())) && ((request.getParameter("txtNome").trim() != null) && (request.getParameter("txtLogin").trim() != null))) {
                estudante.setNome(request.getParameter("txtNome"));
                estudante.setLogin(request.getParameter("txtLogin"));
                estudante.setSenha(request.getParameter("txtSenha"));
                estudante.setEmail(request.getParameter("txtEmail"));

                estudanteCrud.gravar(estudante);

                out.println("<h1>Estudante " + estudante.getNome() + " cadastrado com sucesso!</h1>");
            } else {
                out.println("<h1>Não foi possível concluir o cadastro, verifique se todos os campos foram preenchidos corretamente</h1>");
            }
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
