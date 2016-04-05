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
public class passto extends HttpServlet {

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
            out.println("<title>Storage</title>");            
            out.println("</head>");
            out.println("<body>");
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
            int passl=(int)session.getAttribute("passl");
            String[][] passw= new String[5][5];
            int k=0;
            String sql;
            Statement s;
            ResultSet rs;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(hashv[i][j][k]!=null)
                    passw[i][j]= hashv[i][j][k]+hashv[i][j][k+1]+hashv[i][j][k+2];
                    

                }
            }
        

            if (dbno==2)
            {
            for (int i = 0; i < passl; i++)
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



                        switch (dbno) {
                            case 1:



                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    PreparedStatement u= c1.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                                
                            case 2:
                                   
                             
                                sql = "INSERT into LOGIN(USERNAME,PASSWORD,PASSWORD2,PASSWORD3,PASSWORD4,PASSWORD5) values(?,?,?,?,?,?)";
                                    u= c2.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();
                                break;
                                
                            case 3:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                   u = c3.prepareStatement(sql);
                                   u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                   u.executeUpdate();

                                break;
                            case 4:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c4.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                   u.executeUpdate();


                                break;
                            case 5:

                       sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c5.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                 u.executeUpdate();


                                break;
                            default:
                                break;
                        }

                

            }
                    }
            else if (dbno==3)
            {
            for (int i = 0; i <passl; i++)
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
                                    else if(i==3)
                                {
                                    dbno=5;
                                }


                        switch (dbno) {
                            case 1:



                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    PreparedStatement u= c1.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                     u.executeUpdate();


                                break;
                            case 2:

                                   sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";                                  
                                    u= c2.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                   u.executeUpdate();


                                break;
                            case 3:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                   u = c3.prepareStatement(sql);
                                   
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                     u.executeUpdate();


                                break;
                            case 4:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c4.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                     u.executeUpdate();


                                break;
                            case 5:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                     u = c5.prepareStatement(sql);
                                   u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                     u.executeUpdate();


                                break;
                            default:
                                break;
                        }

                

                    }
                    }
            else if (dbno==4)
            {
            for (int i = 0; i < passl; i++)
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
                                    else if(i==4)
                                {
                                    dbno=2;
                                }

                        switch (dbno) {
                            case 1:



                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    PreparedStatement u= c1.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                     u.executeUpdate();


                                break;
                            case 2:

                                   sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";                                  
                                    u= c2.prepareStatement(sql);
                                    
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                     u.executeUpdate();


                                break;
                            case 3:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                   u = c3.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                            case 4:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c4.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                            case 5:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c5.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                            default:
                                break;
                        }

                

            }
                    }
                    else if (dbno==5)
            {
            for (int i = 0; i < passl; i++)
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


                        switch (dbno) {
                            case 1:



                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    PreparedStatement u= c1.prepareStatement(sql);
                                    
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                            case 2:

                                   sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";                                  
                                    u= c2.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                            case 3:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c3.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                            case 4:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c4.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();


                                break;
                            case 5:

                                    sql = "Insert into login(username,password,password2,password3,password4,password5) values(?,?,?,?,?,?)";
                                    u = c5.prepareStatement(sql);
                                    u.setString(1, userid);
                                    u.setString(2, passw[i][0]);
                                    u.setString(3, passw[i][1]);
                                    u.setString(4, passw[i][2]);
                                    u.setString(5, passw[i][3]);
                                    u.setString(6, passw[i][4]);
                                    u.executeUpdate();
                                break;
                            default:
                                break;
                        }

                

            }
            }
            
            out.println("Entered successfully");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(passto.class.getName()).log(Level.SEVERE, null, ex);
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
