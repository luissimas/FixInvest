/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EstudanteCRUD;
import Model.Estudante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
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
@WebServlet(name = "SPerfilInvestidor", urlPatterns = {"/SPerfilInvestidor"})
public class SPerfilInvestidor extends HttpServlet {

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
        
        Estudante estudante = new Estudante();
        EstudanteCRUD estudanteCrud = new EstudanteCRUD();
        HttpSession sessao;
        
        int conservador = 0, moderado = 0, agressivo = 0;
        String resultado = "";
        
        try {
            sessao = request.getSession(true);
            
            estudante = (Estudante) sessao.getAttribute("estudante");
            
            switch(request.getParameter("cmbExperiencia").toString()){
                case "1":
                    conservador += 10;
                    break;
                case "2":
                    conservador += 5;
                    moderado += 5;
                    break;  
                case "3":
                    moderado += 5;
                    agressivo += 5;
                    break;
                case "4":
                    agressivo += 10;
                    break;
            }
            
            switch(request.getParameter("cmbPretendeResgatar").toString()){
                case "1":
                    conservador += 10;
                    break;
                case "2":
                    conservador += 5;
                    moderado += 5;
                    break;  
                case "3":
                    conservador += 7;
                    moderado += 3;
                    break;
                case "4":
                    agressivo += 10;
                    break;
            }
            
            switch(request.getParameter("cmbToleranciaAPerdas").toString()){
                case "1":
                    conservador += 10;
                    break;
                case "2":
                    conservador += 5;
                    moderado += 5;
                    break;  
                case "3":
                    moderado += 5;
                    agressivo += 5;
                    break;
                case "4":
                    agressivo += 10;
                    break;
            }
            
            if(request.getParameterValues("chkJaInvestiu").toString().contains("Poupança")){
                conservador += 5;
            }
            if(request.getParameterValues("chkJaInvestiu").toString().contains("Renda Fixa")){
                conservador += 3;
                moderado += 3;
            }
            if(request.getParameterValues("chkJaInvestiu").toString().contains("Renda Variável")){
                moderado += 3;
                agressivo += 3;
            }
            if(request.getParameterValues("chkJaInvestiu").toString().contains("Fundos")){
                agressivo += 5;
            }
            
            switch(request.getParameter("cmbFrequenciaQueInvestiu").toString()){
                case "1":
                    conservador += 10;
                    break;
                case "2":
                    conservador += 5;
                    moderado += 5;
                    break;  
                case "3":
                    moderado += 5;
                    agressivo += 5;
                    break;
                case "4":
                    agressivo += 10;
                    break;
            }
            
            switch(request.getParameter("cmbVidaFinanceira").toString()){
                case "1":
                    conservador += 10;
                    break;
                case "2":
                    conservador += 5;
                    moderado += 5;
                    break;  
                case "3":
                    moderado += 5;
                    agressivo += 5;
                    break;
                case "4":
                    agressivo += 10;
                    break;
            }
            
            if((conservador > moderado) && (conservador > agressivo)){
            resultado = "conservador";
            }else if((moderado > conservador) && (moderado > agressivo)){
                resultado = "moderado";
            }else if((agressivo > conservador) && (agressivo > moderado)){
                resultado = "agressivo";
            }
            
            estudante.setPerfil(resultado);
            estudanteCrud.gravarPerfil(estudante);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Perfil de Investidor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");

            out.println("<h1>Resultado do perfil</h1></br>");
            out.println("<h4>Você é um investidor " + resultado + "</h4></br>");
            out.println("<h3>Conservador: " + conservador + "</h3></br>");
            out.println("<h3>Moderado: " + moderado + "</h3></br>");
            out.println("<h3>Agressivo: " + agressivo + "</h3></br>");
            out.println("<a href='perfilinvestidor.jsp'>Concluir</a>");
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
