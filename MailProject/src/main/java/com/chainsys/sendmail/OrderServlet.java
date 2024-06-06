package com.chainsys.sendmail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        // Create OrderDetails object
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setName(name);
        orderDetails.setEmail(email);
        orderDetails.setAddress(address);
        orderDetails.setContact(contact);

        // Insert into database
        try (Connection connection = Connectivity.getConnection()) {
            String query = "INSERT INTO orders (name, email, address, contact) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, address);
            statement.setString(4, contact);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                // Send email
                boolean emailSent = MailUtil.sendEmail(orderDetails);
                if (emailSent) {
                    request.setAttribute("message", "Order placed and email sent successfully!");
                } else {
                    request.setAttribute("message", "Order placed, but email sending failed.");
                }
            } else {
                request.setAttribute("message", "Failed to place order.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Database error: " + e.getMessage());
        }

        // Forward to response page
        RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
        dispatcher.forward(request, response);
	}

}
