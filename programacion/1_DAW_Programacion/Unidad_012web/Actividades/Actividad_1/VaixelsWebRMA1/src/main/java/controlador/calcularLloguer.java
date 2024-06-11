/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lloguervaixells.*;

/**
 *
 * @author RamónMorenoAlbert
 */
public class calcularLloguer  extends HttpServlet  {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String matricula = request.getParameter("matricula");
        ArrayList<Vaixell> vaixells = (ArrayList<Vaixell>) session.getAttribute("vaixels");
        if (matricula == null || matricula.isEmpty() || vaixells == null) {
            request.setAttribute("missatge", "Error matrícula o barco inexixtentes."); //establece e introduce el mensaje de error al redirigir el dispatcher se puede usar para mostrar el mensaje mediante un condicional en la pagina de destino
            request.getRequestDispatcher("llistaVaixells.jsp").forward(request, response);
        } else {
            try {
                int posicion = Integer.parseInt(request.getParameter("posicion"));
                if(posicion<=0){
                   request.setAttribute("missatge", "La posición no puede ser 0 o menos.");
                   request.getRequestDispatcher("simulador.jsp").forward(request, response);
                }else{
                Vaixell vaixell = Vaixell.buscar(vaixells, request.getParameter("matricula"));
                Lloguer alquiler = new Lloguer(request.getParameter("nombre"),
                        request.getParameter("dni"),
                        Integer.parseInt(request.getParameter("dias")),
                        Integer.parseInt(request.getParameter("posicion")),
                        vaixell);

                request.setAttribute("missatge", "Simulación completada.");
                request.setAttribute("alquiler", alquiler);
                request.getRequestDispatcher("mostrarLloguer.jsp").forward(request, response);
                }

            } catch (NumberFormatException e) {
                
                request.setAttribute("missatge", "Los datos nos se han introducido correctamente."); //establece e introduce el mensaje de error al redirigir el dispatcher se puede usar para mostrar el mensaje mediante un condicional en la pagina de destino
                request.getRequestDispatcher("llistaVaixells.jsp").forward(request, response);
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
