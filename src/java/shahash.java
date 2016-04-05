/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.Character.isWhitespace;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class shahash extends HttpServlet {

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
            out.println("<title>Servlet shahash</title>");            
            out.println("</head>");
            out.println("<body>");
            
           // int[][][] plaint=new int[5][5][5];
            
            String[][][] a=new String[5][5][5];
            HttpSession session = request.getSession();
            char[][] split = new char[5][5];
            split=null;

           
            split=(char[][]) session.getAttribute("chardata");
            
            int[][][] plaint = (int[][][]) session.getAttribute("root");
            int r1=plaint.length;
            for (int i = 0; i < r1; i++) {
                int r2=plaint[i].length;
                for (int j = 0; j < r2; j++) {
                    int r3=plaint[i][j].length;
                    for (int k = 0; k < r3; k++) {
                        if(plaint[i][j][k]!=0)
                        {
                            a[i][j][k]= sha256(Integer.toString(plaint[i][j][k]));
                            if(split[i][j] != 0)
                            out.println("data:"+split[i][j]+" <br> a:" + a[i][j][k]+"<br>");
                        }
                    }
                    session.setAttribute("hashed",a);
                }out.println(" <br>");
            }
            out.println("</body>");
            out.println("</html>");
           RequestDispatcher rd = request.getRequestDispatcher("redirect");
          rd.forward(request,response);
          
        }
    }
    
    public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(NoSuchAlgorithmException | UnsupportedEncodingException ex){
       throw new RuntimeException(ex);
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
