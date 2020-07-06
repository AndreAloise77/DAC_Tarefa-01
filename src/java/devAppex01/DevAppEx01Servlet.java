package devAppex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DevAppEx01Servlet extends HttpServlet {

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
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ResultadoServlet\" method=\"post\">");
            out.println("Insira um valor (real) para o primeiro campo abaixo:");
            out.println("<br>");
            out.println("<input type=\"text\" name=\"value1\" value=\"\" placeholder=\"Valor1\">");
            out.println("<br><br>");
            out.println("Escolha uma operação abaixo:");
            out.println("<br>");
            out.println("<select name=\"operacao\">");
            out.println("<option value=\"adicao\">Adição</option>");
            out.println("<option value=\"subtracao\">Subtração</option>");
            out.println("<option value=\"multiplicacao\">Multiplicação</option>");
            out.println("</select><br><br>");
            out.println("Insira um valor (real) para o segundo campo abaixo:<br>");
            out.println("<input type=\"text\" name=\"value2\" value=\"\" placeholder=\"Valor2\">");
            out.println("<br><br>");
            out.println("<input type=\"submit\" style=\"color: green\" name=\"calc\" value=\"Calcular\">");
            out.println("<br><br>");
            out.println("</form>");
            out.println("<a href=\"index.html\"><button><font color=\"blue\">Página Inicial</font></button></a>");
            out.println("</body>");
            out.println("</html>");
    }//func
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
}//class
