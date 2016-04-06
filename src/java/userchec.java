/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shawn
 */
public class userchec extends HttpServlet {

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
            out.println("<title>Servlet userchec</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String uname = request.getParameter("username");
            String pass = request.getParameter("password");
            Connection c1=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash1","ad","ad");
            Connection c2=DriverManager.getConnection("jdbc:derby://localhost:1527/hash2","ad","ad");
            Connection c3=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash3","ad","ad");
            Connection c4=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash4","ad","ad");
            Connection c5=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash5","ad","ad");
            HttpSession session = request.getSession();
            
            String query ="select * from login where username =?";
            PreparedStatement st =c1.prepareStatement(query);
            st.setString(1,uname);
            
            
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next() )
            {   
                
                request.setAttribute("Regn","Username exists");
                
           RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
          rd.forward(request,response);
                
}             
            else
            {
                
            query ="select * from login where username =?";
            st =c2.prepareStatement(query);
            st.setString(1,uname);
            
            
            resultSet = st.executeQuery();
            if (resultSet.next())
            {   
                
                request.setAttribute("Regn","Username exists");
                
           RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
          rd.forward(request,response);
                
}             
            else
            {
                query ="select * from login where username =?";
            st =c3.prepareStatement(query);
            st.setString(1,uname);
            
            
            resultSet = st.executeQuery();
            if (resultSet.next())
            {   
                
                request.setAttribute("Regn","Username exists");
                
           RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
          rd.forward(request,response); 
                
}             
            else
            {
                query ="select * from login where username =?";
            st =c4.prepareStatement(query);
            st.setString(1,uname);
            
            
            resultSet = st.executeQuery();
            if (resultSet.next() )
            {   
                
                request.setAttribute("Regn","Username exists");
               
           RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
          rd.forward(request,response);
                
}             
            else
            {
                query ="select * from login where username =?";
            st =c5.prepareStatement(query);
            st.setString(1,uname);
            resultSet = st.executeQuery();
            if (resultSet.next() )
            {   
                
                request.setAttribute("Regn","Username exists");
                
           RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
          rd.forward(request,response);
                
}             
            else
            {
                
            request.setAttribute("username",uname);
            request.setAttribute("password",pass);
            RequestDispatcher rd = request.getRequestDispatcher("Division");
          rd.forward(request,response);
            
            
            }
            
            
            
            }
            
            
            
            }
            
            
            
            }
            
            
            }
            
         
    
            out.println("</body>");
            out.println("</html>");
        }catch (SQLException ex) {
            Logger.getLogger(userchec.class.getName()).log(Level.SEVERE, null, ex);
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
