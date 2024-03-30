package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lloguervaixells.Esportiu;
import lloguervaixells.Iot;
import lloguervaixells.Vaixell;
import lloguervaixells.Veler;

/**
 *
 * @author RamónMorenoAlbert
 */
public class addVaixell extends HttpServlet {

    private static ArrayList<Vaixell> vaixels;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (vaixels == null) {
            vaixels = new ArrayList<>();
            session.setAttribute("vaixels", vaixels);
        }
        String tipus = request.getParameter("tipus");
        String nextPage = "llistaVaixells.jsp";
        String missatge = null;

        try {
            switch (tipus) {
                case "veler":
                    int mastiles = Integer.parseInt(request.getParameter("mastelers"));
                    if (mastiles < 0) {
                        missatge = "Los mástiles no pueden ser un número negativo.";
                    } else {
                        Veler veler = new Veler(
                                Integer.parseInt(request.getParameter("mastelers")),
                                request.getParameter("matricula"),
                                Double.parseDouble(request.getParameter("eslora")),
                                Integer.parseInt(request.getParameter("anyFabricacio"))
                        );
                        if (Vaixell.buscar(vaixels, veler.getMatricula()) == null) {
                            vaixels.add(veler);
                        } else {
                            missatge = "La matrícula ya existe.";
                        }
                    }
                    break;

                case "esportiva":
                    int potencia = Integer.parseInt(request.getParameter("potencia"));
                    if (potencia < 0) {
                        missatge = "La potencia no puede ser un número negativo";
                    } else {
                        Esportiu esportiu = new Esportiu(
                                Integer.parseInt(request.getParameter("potencia")),
                                request.getParameter("matricula"),
                                Double.parseDouble(request.getParameter("eslora")),
                                Integer.parseInt(request.getParameter("anyFabricacio"))
                        );
                        if (Vaixell.buscar(vaixels, esportiu.getMatricula()) == null) {
                            vaixels.add(esportiu);
                        } else {
                            missatge = "La matrícula ya existe.";
                        }
                    }
                    break;

                case "iot":
                    potencia = Integer.parseInt(request.getParameter("potencia"));
                    int cabinas = Integer.parseInt(request.getParameter("cabines"));
                    if (potencia < 0) {
                        missatge = "La potencia no puede ser un número negativo";
                    } else if (cabinas < 0) {
                        missatge = "Las cabinas no puede ser un número negativo";

                    } else {
                        Iot iot = new Iot(
                                Integer.parseInt(request.getParameter("cabines")),
                                Integer.parseInt(request.getParameter("potencia")),
                                request.getParameter("matricula"),
                                Double.parseDouble(request.getParameter("eslora")),
                                Integer.parseInt(request.getParameter("anyFabricacio"))
                        );
                        if (Vaixell.buscar(vaixels, iot.getMatricula()) == null) {
                            vaixels.add(iot);
                        } else {
                            missatge = "La matrícula ya existe.";
                        }
                        break;
                    }
            }
        } catch (NumberFormatException e) {
            missatge = "Error: Los datos introducidos no están en formato correcto";
        }
        request.setAttribute("missatge", missatge);
        request.getRequestDispatcher(nextPage).forward(request, response);

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
