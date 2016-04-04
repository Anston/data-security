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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shawn
 */
public class passtore extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet passtore</title>");            
            out.println("</head>");
            out.println("<body> ");
            Connection c1=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash1","ad","ad");
            Connection c2=DriverManager.getConnection("jdbc:derby://localhost:1527/hash2","ad","ad");
            Connection c3=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash3","ad","ad");
            Connection c4=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash4","ad","ad");
            Connection c5=DriverManager.getConnection("jdbc:derby://localhost:1527/Hash5","ad","ad");
            HttpSession session = request.getSession();
             
            String userid=(String) session.getAttribute("uname");
            String[][][] hashv = null;
            hashv=(String[][][]) session.getAttribute("hashed");
            int dbno=(int)session.getAttribute("f");
            String[][] passw = null;
            int k=0;
            String sql;
            Statement s;
            ResultSet rs;
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    
                    passw[i][j]= hashv[i][j][k].concat(hashv[i][j][k+1]).concat(hashv[i][j][k+2]).concat(hashv[i][j][k+3]).concat(hashv[i][j][k+4]);
                    
                    
                }
            }
           
                
           if (dbno==2)
            {
            for (int i = 0; i < 5; i++) 
            {
                if(i==0)
                {
                dbno=2;    
                }
                else if(i==1)
                        {
                            dbno=3;
                        }
                else if(i==2)
                                {
                                    dbno=4;
                                }
            
                for (int j = 0; j < 5; j++) {
                    
                        switch (dbno) {
                            case 1:

                                sql = "SELECT * FROM login WHERE username = ?";
                                PreparedStatement preparedStatement = c1.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c1.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c1.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c1.createStatement();
                                    preparedStatement.executeQuery();

                                }
                                break;
                            case 2:
                                     sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c2.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c2.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c2.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c2.createStatement();
                                    preparedStatement.executeQuery();

                                }

                                break;
                            case 3:
                                 sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c3.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c3.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c3.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c3.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 4:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c4.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                s = c4.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c4.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c4.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 5:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c5.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c5.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c5.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c5.createStatement();
                                    preparedStatement.executeQuery();
                                    
                                    
                                }

                                break;
                            default:
                                break;
                        }
                    
                }

            }
            if (dbno==3)
            {
            for (int i = 0; i < 5; i++) 
            {
                if(i==0)
                {
                dbno=3;    
                }
                else if(i==1)
                        {
                            dbno=4;
                        }
                else if(i==2)
                                {
                                    dbno=5;
                                }
            
                for (int j = 0; j < 5; j++) {
                    
                        switch (dbno) {
                            case 1:

                                sql = "SELECT * FROM login WHERE username = ?";
                                PreparedStatement preparedStatement = c1.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c1.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c1.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c1.createStatement();
                                    preparedStatement.executeQuery();

                                }
                                break;
                            case 2:
                                     sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c2.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c2.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c2.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c2.createStatement();
                                    preparedStatement.executeQuery();

                                }

                                break;
                            case 3:
                                 sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c3.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c3.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c3.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c3.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 4:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c4.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                s = c4.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c4.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c4.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 5:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c5.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c5.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c5.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c5.createStatement();
                                    preparedStatement.executeQuery();
                                    
                                    
                                }

                                break;
                            default:
                                break;
                        }
                    
                }

            }
            if (dbno==4)
            {
            for (int i = 0; i < 5; i++) 
            {
                if(i==0)
                {
                dbno=4;    
                }
                else if(i==1)
                        {
                            dbno=5;
                        }
                else if(i==2)
                                {
                                    dbno=1;
                                }
            else if(i==3)
                                {
                                    dbno=2;
                                }
                            
                for (int j = 0; j < 5; j++) {
                    
                        switch (dbno) {
                            case 1:

                                sql = "SELECT * FROM login WHERE username = ?";
                                PreparedStatement preparedStatement = c1.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c1.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c1.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c1.createStatement();
                                    preparedStatement.executeQuery();

                                }
                                break;
                            case 2:
                                     sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c2.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c2.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c2.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c2.createStatement();
                                    preparedStatement.executeQuery();

                                }

                                break;
                            case 3:
                                 sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c3.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c3.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c3.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c3.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 4:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c4.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                s = c4.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c4.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c4.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 5:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c5.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c5.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c5.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c5.createStatement();
                                    preparedStatement.executeQuery();
                                    
                                    
                                }

                                break;
                            default:
                                break;
                        }
                    
                }

            }
            if (dbno==5)
            {
            for (int i = 0; i < 5; i++) 
            {
                if(i==0)
                {
                dbno=5;    
                }
                else if(i==1)
                        {
                            dbno=1;
                        }
                else if(i==2)
                                {
                                    dbno=2;
                                }
                else if(i==3)
                                {
                                    dbno=3;
                                }
                else if(i==4)
                                {
                                    dbno=4;
                                }
            
                for (int j = 0; j < 5; j++) {
                    
                        switch (dbno) {
                            case 1:

                                sql = "SELECT * FROM login WHERE username = ?";
                                PreparedStatement preparedStatement = c1.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c1.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c1.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c1.createStatement();
                                    preparedStatement.executeQuery();

                                }
                                break;
                            case 2:
                                     sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c2.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c2.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c2.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c2.createStatement();
                                    preparedStatement.executeQuery();

                                }

                                break;
                            case 3:
                                 sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c3.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c3.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c3.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c3.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 4:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c4.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                s = c4.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c4.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c4.createStatement();
                                    preparedStatement.executeQuery();
                                }

                                break;
                            case 5:
                                sql = "SELECT * FROM login WHERE username = ?";
                                preparedStatement = c5.prepareStatement(sql);
                                preparedStatement.setString(1, userid);

                                 s = c5.createStatement();
                                 rs = preparedStatement.executeQuery();

                                if (rs.next()) {

                                    out.println("The username is taken");

                                } else {

                                    sql = "Insert into login values("+userid+","+passw[i][j]+")";
                                    preparedStatement = c5.prepareStatement(sql);
                                    preparedStatement.setString(1, userid);
                                    s = c5.createStatement();
                                    preparedStatement.executeQuery();
                                    
                                    
                                }

                                break;
                            default:
                                break;
                        }
                    
                }

            }
            
            }
            
            
            out.println("</body>");
            out.println("</html>");
        
          
            catch (SQLException ex)
                {
            Logger.getLogger(passtore.class.getName()).log(Level.SEVERE, null, ex);
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
   // @Override
    //protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //        throws ServletException, IOException {
    //    processRequest(request, response);
    }
//
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
