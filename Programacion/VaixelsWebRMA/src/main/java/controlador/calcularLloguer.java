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
import javax.servlet.http.HttpSession;
import lloguervaixells.Lloguer;
import lloguervaixells.Vaixell;
import lloguervaixells.*;

/**
 *
 * @author Usuario
 */
public class calcularLloguer extends HttpServlet {

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
            out.println("<title>Servlet calcularLloguer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet calcularLloguer at wet" + request.getContextPath() + "</h1>");
            HttpSession session = request.getSession();   // necesito crear session
            ArrayList<Vaixell> vaixells = (ArrayList<Vaixell>) session.getAttribute("vaixels"); 
            
           // Vaixell vaixell =  Vaixell.buscar(addVaixell.vaixels, request.getParameter("matricula"));
             Vaixell vaixell = Vaixell.buscar(vaixells, request.getParameter("matricula"));
             out.println(vaixell.toString());
             int dias = Integer.parseInt(request.getParameter("dias"));
             String dni = request.getParameter("dni");
             String nombre = request.getParameter("nombre");
             
             //metodo del alquiler
            Lloguer alquiler = new Lloguer(request.getParameter("nombre"),
                    request.getParameter("dni"), 
                    Integer.parseInt(request.getParameter("dias")),
                    Integer.parseInt(request.getParameter("posicion")),
                    vaixell);
            //uso el return
            double precio =alquiler.getPreuLloguer();
          
            out.println("<h2> nombre = "+nombre+"</h2>");
            out.println("<h2> dni = "+dni+"</h2>");
            out.println("<h2> dias = "+dias+"</h2>");
            out.println("<h2> Precio = "+precio+"</h2>");
            out.println("<h2> datos = "+vaixell.toString()+"</h2>");
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
