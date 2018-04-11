/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arm_p
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Connection conn;
    
        public void init() {
            conn = (Connection) getServletContext().getAttribute("connection");
        }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM account_db WHERE username = '"+ username +"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()){
                String pwd_table = rs.getString("password");
                if (pwd_table.equals(password)){
                    HttpSession session = request.getSession();
                    String first_name = rs.getString("first_name");
                    String last_name = rs.getString("last_name");
                    session.setAttribute("first_name", first_name);
                    session.setAttribute("last_name", last_name);
                    response.sendRedirect("seller_page.html");
                    
                }else {
//                    response.sendRedirect("login_error.html");

out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bootstrap Example</title>"
                    + "<meta charset=\"utf-8\">"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
                    + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>"
                    + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>"
                    + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>"
                    + "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            
            
           
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n" +
"	<div class=\"container\">\n" +
"		<a class=\"navbar-brand\" href=\"homepage.html\">Used Car Market Online</a>\n" +
"			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor01\" aria-controls=\"navbarColor01\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"				<span class=\"navbar-toggler-icon\"></span>\n" +
"			</button>\n" +
"\n" +
"		<div class=\"collapse navbar-collapse\" id=\"navbarColor01\">\n" +
"			<ul class=\"navbar-nav ml-auto\">\n" +
"				<li class=\"nav-item\"> <!--active-->\n" +
"					<a class=\"nav-link\" href=\"login.html\">Login <span class=\"sr-only\">(current)</span></a>\n" +
"				</li>\n" +
"				<li class=\"nav-item\">\n" +
"					<a class=\"nav-link\" href=\"register.html\">Register</a>\n" +
"				</li>\n" +
"			</ul>\n" +
"		</div>\n" +
"</nav>");
            
            
            out.println("<div class=\"container\">\n" +
"  <h2>Login Fail</h2>\n" +
"  <div class=\"alert alert-success alert-dismissible fade in\">\n" +
"    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"    <strong>Success!</strong> This alert box could indicate a successful or positive action.\n" +
"  </div>\n" +
"  <div class=\"alert alert-info alert-dismissible fade in\">\n" +
"    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"    <strong>Info!</strong> This alert box could indicate a neutral informative change or action.\n" +
"  </div>\n" +
"  <div class=\"alert alert-warning alert-dismissible fade in\">\n" +
"    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"    <strong>Warning!</strong> This alert box could indicate a warning that might need attention.\n" +
"  </div>\n" +
"  <div class=\"alert alert-danger alert-dismissible fade in\">\n" +
"    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"    <strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.\n" +
"  </div>\n" +
"</div>");
            

            out.println("</body>");
            out.println("</html>");
                }
            }
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
