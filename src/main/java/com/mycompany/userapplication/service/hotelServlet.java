/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.userapplication.service;

import entity.HotelRoom;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author KAMINI
 */
@WebServlet(name = "hotelServlet", urlPatterns = {"/hotelServlet"})
public class hotelServlet extends HttpServlet {
    
    @Inject 
    @RestClient hotelClient hcl;
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
            
             String city = request.getParameter("city");
            String tname = request.getParameter("tname");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hotelServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2>Search Hotel</h2>");
            out.println("<form method='post' action='hotelServlet'>");
            out.println("City :");
            out.println("<input type='text' name='city' required>");
            out.println("Room Type :");
            out.println("<input type='text' name='tname' required>");
            out.println("<br><br>");
            out.println("<button type='submit'>Serch</button>");
            out.println("</form>");
             if (city != null && tname != null
                    && !city.isEmpty() && !tname.isEmpty()) {

                out.println("<hr>");
                out.println("<h2>Hotel Search Result</h2>");

                try {

                    List<HotelRoom> hotels =
                            hcl.getHotels(city, tname);

                    if (hotels.isEmpty()) {

                        out.println("<p>No hotels found.</p>");

                    } else {

                        for (HotelRoom h : hotels) {

                            out.println("<hr>");

                            out.println("<p><b>Hotel Name:</b> "
                                    + h.getId().getHname()
                                    + "</p>");

                            out.println("<p><b>Hotel Type:</b> "
                                    + h.getId().getHtype()
                                    + "</p>");

                            out.println("<p><b>Hotel Address:</b> "
                                    + h.getId().getAddr()
                                    + "</p>");

                            out.println("<p><b>Hotel City:</b> "
                                    + h.getId().getCity()
                                    + "</p>");

                            out.println("<p><b>Room Type:</b> "
                                    + h.getTid().getTname()
                                    + "</p>");

                            out.println("<p><b>Charge:</b> "
                                    + h.getTid().getCharge()
                                    + "</p>");

                            out.println("<p><b>Available Rooms:</b> "
                                    + h.getTid().getAroom()
                                    + "</p>");
                        }
                    }

                } catch (Exception e) {

                    out.println("<p style='color:red;'>");
                    out.println("Error: " + e.getMessage());
                    out.println("</p>");
                }
            }
           
            
            
            
            
            
            
            
            out.println("<h1>Servlet hotelServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
