package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    private String missatge;
   // private boolean anyadido; //pruebas

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
            // out.println("<h1>Servlet addVaixell at " + request.getContextPath() + "</h1>");
            HttpSession session = request.getSession();
            //si el array está vacio, lo inicializa

            missatge = (String) session.getAttribute("missatge");
            session.setAttribute("missatge", missatge);  //necesario ponerlo despues de cada modificación del string
            vaixels = (ArrayList<Vaixell>) session.getAttribute("vaixels");  //variable de session
            if (vaixels == null) {
                vaixels = new ArrayList<>();
                session.setAttribute("vaixels", vaixels); // introduce datos a la variable de sesion
            }
            //agrego condiciones, cada tipo de barco, recibe unos parametros para ser  creado. 
            String tipus = request.getParameter("tipus");
            if (tipus.equals("veler")) {
                try {
                    Veler veler = new Veler(
                            Integer.parseInt(request.getParameter("mastelers")), // necesario usar parse para transformar al dato que espera el constructor.
                            request.getParameter("matricula"), // en caso de los strings es el parametro por defecto.
                            Double.parseDouble(request.getParameter("eslora")),
                            Integer.parseInt(request.getParameter("anyFabricacio"))
                    );
                    if (Vaixell.buscar(vaixels, veler.getMatricula()) == null) {
                        vaixels.add(veler);
                        missatge = "Velero añadido correctamente.";
                       // anyadido = true;
                        session.setAttribute("missatge", missatge);
                       // session.setAttribute("anyadido", anyadido);
                        

                        response.sendRedirect("anyadidoBarco.jsp");
                    } else {
                        missatge = "Algo a fallado. La matrícula existe.";

                        session.setAttribute("missatge", missatge);
                        response.sendRedirect("anyadidoBarco.jsp");
                    }
                } catch (NumberFormatException e) {
                    out.println("<p>Error: Los datos introducidos no están en formato correcto</p>");
                }
            }

            if (tipus.equals("esportiva")) {
            try {
                
                    Esportiu esportiu = new Esportiu(Integer.parseInt(request.getParameter("potencia")),
                            request.getParameter("matricula"),
                            Double.parseDouble(request.getParameter("eslora")),
                            Integer.parseInt(request.getParameter("anyFabricacio")));
                    if (Vaixell.buscar(vaixels, esportiu.getMatricula()) == null) {
                        vaixels.add(esportiu);
                        missatge = "Esportiu añadido correctamente.";
                        session.setAttribute("missatge", missatge);                    

                        response.sendRedirect("anyadidoBarco.jsp");
                    } else {
                        missatge = "Algo a fallado. La matrícula existe.";

                        session.setAttribute("missatge", missatge);
                        response.sendRedirect("anyadidoBarco.jsp");
                    }

                
            } catch (NumberFormatException e) {
                out.println("<p>Error: Los datos introducidos no están en formato correcto</p>");
            }
            }
            if (tipus.equals("iot")) {
                try {
                    Iot iot = new Iot(
                            Integer.parseInt(request.getParameter("cabines")),
                            Integer.parseInt(request.getParameter("potencia")),
                            request.getParameter("matricula"),
                            Double.parseDouble(request.getParameter("eslora")),
                            Integer.parseInt(request.getParameter("anyFabricacio"))
                    );
                    if (Vaixell.buscar(vaixels, iot.getMatricula()) == null) {
                        vaixels.add(iot);
                        missatge = "Iot añadido correctamente.";
                        session.setAttribute("missatge", missatge);

                        response.sendRedirect("anyadidoBarco.jsp");
                    } else {
                        missatge = "Algo a fallado. La matrícula existe.";

                        session.setAttribute("missatge", missatge);
                        response.sendRedirect("anyadidoBarco.jsp");
                    }

                } catch (NumberFormatException e) {
                    out.println("<p>Error: Los datos introducidos no están en formato correcto</p>");
                }
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
