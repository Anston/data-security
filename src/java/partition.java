/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;
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
public class partition extends HttpServlet {

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

            out.println("</head>");
            out.println("<body>");
            int r[]= new int[3];
            char[][] split=null;
            int pr=1,p;
            HttpSession session = request.getSession();
            split = (char[][]) session.getAttribute("split");
            char[] dr=new char[5];
            int[][][] roots=new int[5][5][5];
            int[] d=new int[5];
            String uname = (String)session.getAttribute("uname");


            /* int row = split.length;
            for (int i = 0; i < row; i++)
            {
            int col = split[i].length;
            for (int j = 0; j < col; j++) {
            out.println("split:" + split[i][j]);
            }
            }*/
            int row=split.length;
            for(int count=0;count<row;count++)
            {   pr=1;
                int col= split[count].length;
                for(int k=0;k<col;k++)
                {
                    dr[k]=split[count][k]; //Take the divided group of letters
                }


                for(int i=0;i<2;i++)
                {
                  r[i]= partition.randInt();  // choose k-1 roots randomly
                  
                  pr=pr*r[i];
                }


                int row1 = dr.length;
                for(int i =0;i<row1;i++)
                {
                  d[i]=asciiconv(split[count][i]); //select prime
                  p = selectp(d[i]);
                  
               // out.println("<br><br><br>data:"+d[i]+" prime "+p);
                  if(d[i]!=0)
                  {r[2] = (d[i]*1000/pr)%p;   // find kth root
                  out.println("<br><br><br>data:"+d[i]);}
                for(int k=0;k<3;k++)
                { roots[count][i][k]=r[k];
                if(d[i]!=0)
                {
                out.println("<br>roots:"+roots[count][i][k]);
                }
                }
              }
            

                out.println("</body>");
                out.println("</html>");
                
                
          }
                session.setAttribute("uname",uname);
                session.setAttribute("root", roots);
                
                session.setAttribute("chardata", split);
            RequestDispatcher rd = request.getRequestDispatcher("shahash");
            rd.forward(request,response);}
    }



public static int randInt() {
    int min=1;
    int max=100;
    int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    return randomNum;
}

public static int selectp(int a)
{
    int prime = 0,i,j;
    for (i=a;i>=a;i++)
    {for(j=2;j<=i;j++){
    
    if(i%j==0)
    {
      break;
    }
    }
    if(i==j)
    {
    prime=i;
    break;
    }
    
    

    }
    return prime;
}
           public static int asciiconv(char m)
           {
           int a= m;
           return a;
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
