package com.j2ee.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarpoolingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<String> availableRides;

    @Override
    public void init() throws ServletException {
        availableRides = new CopyOnWriteArrayList<>(); 
        System.out.println("CarpoolingServlet initialized.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Carpooling Service</h1>");
        out.println("</ul>");
        out.println("<h2>Offer your Ride:</h2>");
        out.println("<form method='POST'>");
        out.println("<br>");
        out.println("Pickup Location: <input type='text' name='start'><br>");
        out.println("<br>");
        out.println("Destination: <input type='text' name='destination'><br>");
        out.println("<br>");
        out.println("Available Seats: <input type='number' name='seats'><br>");
        out.println("<br>");
        out.println("<input type='submit' value='Confirm'>");
        out.println("</form>");
        
        out.println("<h2>Your Rides:</h2>");
        out.println("_________________________________________");
        out.println("<ul>");
        for (String ride : availableRides) {
            out.println("<li>" + ride + "</li>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String destination = request.getParameter("destination");
        String seats = request.getParameter("seats");
        
        String newRide = "From " + start + " to " + destination + " with " + seats + " seats.";
        availableRides.add(newRide); 
        
        response.sendRedirect("Carpool"); 
    }

    @Override
    public void destroy() {
        System.out.println("CarpoolingServlet terminated.");
    }
}
