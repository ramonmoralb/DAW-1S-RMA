/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Circulo;
import modelo.Figura;
import modelo.Rectangulo;
import modelo.TrianguloEquilatero;

/**
 *
 * @author Usuario
 */
public class ProcessarFormulari extends HttpServlet {

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
        
        ArrayList<Figura> listaFiguras = (ArrayList<Figura>) request.getSession().getAttribute("listaFiguras"); 
        String paginaError = "error.jsp";
        String paginaResultado = "resultado.jsp";
        
        if ( listaFiguras==null || listaFiguras.isEmpty()){
             listaFiguras = new ArrayList<>();
             request.getSession().setAttribute("listaFiguras", listaFiguras);
        }
        String figura = request.getParameter("figura");
        
        
        try {
            switch (figura) {
                case "cercle":
                    Circulo c = new Circulo(Double.parseDouble(request.getParameter("radi")), request.getParameter("color"));
                        listaFiguras.add(c);
                        response.sendRedirect(paginaResultado);
                break;
                case "rectangle":
                    Rectangulo r = new Rectangulo(Double.parseDouble(request.getParameter("baseRectangle")), Double.parseDouble(request.getParameter("alturaRectangle")), request.getParameter("color"));
                        listaFiguras.add(r);
                        response.sendRedirect(paginaResultado);
                break;    
                case "triangle":
                    TrianguloEquilatero t = new TrianguloEquilatero(Double.parseDouble(request.getParameter("baseTriangle")), Double.parseDouble(request.getParameter("alturaTriangle")), request.getParameter("color"));
                        listaFiguras.add(t);
                        
                        response.sendRedirect(paginaResultado);
                break;    
                default:
                    response.sendRedirect(paginaError);
            }
            
            
        } catch (Exception e) {
            
            response.sendRedirect(paginaError);
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
