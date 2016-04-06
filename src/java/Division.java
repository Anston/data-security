/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");            
            out.println("</head>");
            out.println("<body>");
            int[] a={1,4,9,16,25};
            int i,c = 0,e,f = 0,m,n;
            char passplit[][] = new char[5][5];
            int counter = 0;
            String uname =(String) request.getAttribute("username");
            String pass =(String) request.getAttribute("password");
            char passw[]=pass.toCharArray();
            char split[]= new char[10];
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
          
      
          /*  for (int j = 0; j < 9; j++) {
          out.println("<h1>f=" + f + "</h1>");
          }*/
       for (int j = 0; j <= b-f+1; j+= f)
       {   if(j+f<=b)
           split= Arrays.copyOfRange(passw,j,j + f);
           else  if (j+f-1<=b)
           split= Arrays.copyOfRange(passw,j,j + f-1);
           else if (j+f-2<=b)
            split= Arrays.copyOfRange(passw,j,j + f-2);
            
            
            for(i=0;i<split.length;i++)
            {
            passplit[counter][i]=split[i];
            }
            counter++;
       }
       int passl =b/f;
       
        out.println("</body>");
            out.println("</html>");
            
            HttpSession session = request.getSession();
            session.setAttribute("f",f);
            session.setAttribute("uname",uname);
            session.setAttribute("pass",pass);
            session.setAttribute("passl",passl);
            session.setAttribute("split", passplit);
            
            RequestDispatcher rd = request.getRequestDispatcher("partition");
            rd.forward(request,response);
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
