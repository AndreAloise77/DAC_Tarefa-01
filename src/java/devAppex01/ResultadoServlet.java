package devAppex01;

import utils.Calculator;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    private int visitedCounter = 1;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            //
            String cookieValue = String.valueOf(visitedCounter);
            Cookie cookie = new Cookie("Visited", cookieValue);
            cookie.setMaxAge(11);
            response.addCookie(cookie);
            //
            PrintWriter out = response.getWriter();
            Calculator calculator = new Calculator();
            //
            calculator.setValor1(request.getParameter("value1"));
            calculator.setValor2(request.getParameter("value2"));
            calculator.setOperacao(request.getParameter("operacao"));
            //
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado</title>");            
            out.println("</head>");
            out.println("<body>");
            if(calculator.hasError()){
                out.println("Error(s): " + calculator.getErrorMessage());
            }//if
            else{
                out.println("Resultado da Operação: " + calculator.calculateOperation());
            }//else
            out.println("<br>");
            out.println("Você acessou esta página "+cookie.getValue()+" vezes");
            out.println("<br><br>");
            out.println("<a href=\"DevAppEx01Servlet\"><button><font color=\"blue\">Voltar</font></button></a>");
            out.println("</body>");
            out.println("</html>");
            //
            visitedCounter++;
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
