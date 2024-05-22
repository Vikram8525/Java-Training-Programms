package com.chainsys.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.util.Connectivity;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DemoServerPojo demo = new DemoServerPojo();
	Demo d = new Demo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fname");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        String pass = request.getParameter("password");
        String rpass = request.getParameter("repassword");
//        d.add(name, phone, date, pass, rpass);
        demo.setName(name);
        demo.setPhone(phone);
        demo.setDate(date);
        demo.setPass(pass);
        demo.setRpass(rpass);
        
        try {
			d.registerUser(demo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			request.setAttribute("viewing",d.listOfUsers());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.getRequestDispatcher("displayData.jsp").forward(request, response);
        

    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String action = request.getParameter("action");
		if(action != null) {
			switch (action) {
            case "delete":
                try {
                    int idToDelete = Integer.parseInt(request.getParameter("deleteid"));
                    Demo d = new Demo();
                    d.deleteUser(idToDelete);
                } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    
                }
                try {
					request.setAttribute("viewing",d.listOfUsers());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                request.getRequestDispatcher("displayData.jsp").forward(request, response);
                break;
			}
		}
	}

}
