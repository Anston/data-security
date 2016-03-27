/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shawn
 */
public class Division extends HttpServlet 
{

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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            int[] a={1,4,9,16,25};
            String passplit[] = new String[5];
            int counter = 0;
            int i,c,e,f,x;
            String uname = request.getParameter("username");
            String pass = request.getParameter("pass");
            char Pass[]=pass.toCharArray();
            int b = pass.length();
         for(i=0;i<5;)
	    {
		if(a[i]>b)
		{
		    c=a[i];
		    break;
		}
		else
		{
		i++;
		}
	    }
		 int d;
            d = a[i-1];
          int m,n;
          m= b-d;
          n= c-b;
          if(m<n)
          {
              e=d;
          }
          else
          {
              e=c;
          }
          
          switch(e)
          {
              case 1:
                  f=1;
                  break;
              case 4:
                  f=2;
                  break;
              case 9:
                  f=3;
                  break;
              case 16:
                  f=4;
                  break;
              case 25:
                  f=5;
                  break;
              default:
                  break;
                } 
       for (int j = 0; i < b-f+1; i+= f)
    passplit[counter++] = Arrays.copyOfRange(Pass[],j,j + f);
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
