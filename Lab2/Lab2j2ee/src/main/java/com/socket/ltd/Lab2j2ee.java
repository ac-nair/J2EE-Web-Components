package com.socket.ltd;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Lab2j2ee")
public class Lab2j2ee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Proceed to the quote requesting by using an HTML file</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String socketType = request.getParameter("socketType");
        String qtyStr = request.getParameter("quantity");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        int qty = 0;
        boolean isValid = true;
        
        if (qtyStr != null && qtyStr.matches("\\d+")) 
        {
        	qty = Integer.parseInt(qtyStr);
        } else 
        {
            isValid = false;
            out.println("<h3>Invalid input. Please enter a numeric value.</h3>");
        }

        if (isValid) 
        {
            double pricePerSocket = getSocketPrice(socketType);
            double totalPrice = pricePerSocket * qty;
            
            out.println("<h1>Your quote receipt</h1>");
            out.println("<p>Your name: " + name + "</p>");
            out.println("<p>The receipt will be sent to: " + email + "</p>");
            out.println("<p>Socket Type: " + socketType + "</p>");
            out.println("<p>Quantity: " + qty + "</p>");
            out.println("<p>Total Price: $" + totalPrice + "</p>");
            
        }

        out.close();
    }

    private double getSocketPrice(String socketType) {
        switch (socketType) {
            case "Type A":
                return 30;
            case "Type B":
                return 40;
            case "Type C":
                return 30;
            default:
                return 0;
        }
    }
}
