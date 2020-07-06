package devAppex01;

import utils.Calculadora;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultadoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */ 
    
    private int count = 1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

            String k=String.valueOf(count);
            Cookie c = new Cookie("visit",k);
            c.setMaxAge(11);
            response.addCookie(c);
            
            PrintWriter out = response.getWriter();
            Calculadora calculadora = new Calculadora();
            //
            calculadora.setValor1(request.getParameter("value1"));
            calculadora.setValor2(request.getParameter("value2"));
            calculadora.setOperacao(request.getParameter("operacao"));
            //
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultadoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(calculadora.hasError()){
                out.println("Error: " + calculadora.getErrorMessage());
            }//if
            else{
                out.println("Resultado: " + calculadora.calcular());
            }//else
            out.println("<br>");
            out.println("You visited "+c.getValue()+" times");
            out.println("<br>");
            out.println("<a href=\"DevAppEx01Servlet\">Voltar</a>");
            out.println("</body>");
            out.println("</html>");
            count++;
            Time timer = Time.valueOf(LocalTime.MIN);
            
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
    }//func

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
    }//func

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
