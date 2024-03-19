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
import lloguervaixells.Vaixell;
import lloguervaixells.Veler;

/**
 *
 * @author Usuario
 */
public class addVaixell extends HttpServlet {

    private static ArrayList<Vaixell> vaixels;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addVaixell</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addVaixell at " + request.getContextPath() + "</h1>");
            //si el array está vacio, lo inicializa
            if (vaixels == null) {
                vaixels = new ArrayList<>();
            }
            //agrego condiciones, cada tipo de barco, recibe unos parametros para ser  creado. 
            String tipus = request.getParameter("tipus");
            if (tipus.equals("veler")) {
                Veler veler = new Veler(
                        Integer.parseInt(request.getParameter("mastelers")), // necesario usar parse para transformar al dato que espera el constructor.
                        request.getParameter("matricula"),                  // en caso de los strings es el parametro por defecto.
                        Double.parseDouble(request.getParameter("eslora")),
                        Integer.parseInt(request.getParameter("anyFabricacio"))
                );

                vaixels.add(veler);
                out.println("<p>Añadido </p>" + veler.toString());
            }

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
