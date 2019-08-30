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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Padawan
 */
@WebServlet(name = "SLogin", urlPatterns = {"/SLogin"})
public class SLogin extends HttpServlet {

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
            Estudante estudante = new Estudante();
            EstudanteCRUD estudanteCrud = new EstudanteCRUD();
            HttpSession sessao;

            try {
                estudante = estudanteCrud.login(request.getParameter("txtEmail"), request.getParameter("txtSenha"));

                if (estudante != null) {
                    sessao = request.getSession(true);
                    sessao.setAttribute("estudante", estudante);
                    sessao.setMaxInactiveInterval(1200); //Tempo limite da sessão: 20min

                    response.sendRedirect("home.html");
                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Cadastrar</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Erro no login ou senha.</h1>");
                    out.println("<div align='right'>"
                            + "<input type='button' name='btnEnviar' value='Voltar' onClick='history.go(-1)'/>\n"
                            + "</div>");
                    out.println("</body>");
                    out.println("</html>");
                }

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
            Escritor escritor = new Escritor();
            EscritorCRUD escritorCrud = new EscritorCRUD();
            HttpSession sessao;

            try {
                escritor = escritorCrud.login(request.getParameter("txtEmail"), request.getParameter("txtSenha"));

                if (escritor != null) {
                    sessao = request.getSession(true);
                    sessao.setAttribute("escritor", escritor);
                    sessao.setMaxInactiveInterval(1200); //Tempo limite da sessão: 20min

                    response.sendRedirect("home.html");
                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Cadastrar</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Erro no login ou senha.</h1>");
                    out.println("<div align='right'>"
                            + "<input type='button' name='btnEnviar' value='Voltar' onClick='history.go(-1)'/>\n"
                            + "</div>");
                    out.println("</body>");
                    out.println("</html>");
                }

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
