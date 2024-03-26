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

            HttpSession session = request.getSession();   // necesito crear session
            
            String matricula = request.getParameter("matricula");
            ArrayList<Vaixell> vaixells = (ArrayList<Vaixell>) session.getAttribute("vaixels");
            if(matricula == null||matricula.isEmpty()||vaixells==null){
                  request.setAttribute("error", "aqui el mensaje de error"); //establece e introduce el mensaje de error al redirigir el dispatcher se puede usar para mostrar el mensaje mediante un condicional en la pagina de destino
                  request.getRequestDispatcher("llistaVaixells.jsp").forward(request, response); 
            }
            else{
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
            request.setAttribute("missatge", "");
            request.setAttribute("alquiler", alquiler);
            request.getRequestDispatcher("mostrarLloguer.jsp").forward(request, response);
          
            }/*
            out.println("<p>antes del dispatcher</p>");
            request.setAttribute("error", "aqui el mensaje de error");
            request.getRequestDispatcher("llistaVaixells.jsp").forward(request, response); 
            */
            
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
