package com.chainsys.iamgesample;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet("/UploadImageServlet")
@MultipartConfig(maxFileSize = 16177215) // 16 MB
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
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
//		doGet(request, response);
		String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");

        InputStream inputStream = null;
        Part filePart = request.getPart("image");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }

        byte[] imageBytes = null;
        if (inputStream != null) {
            imageBytes = inputStream.readAllBytes();
        }

        dao product = new dao();
        product.setName(productName);
        product.setDescription(productDescription);
        product.setImage(imageBytes);

        DAOHandler handler = new DAOHandler();
        String message = null;
        if (handler.saveProduct(product)) {
            message = "File uploaded and saved into database";
        } else {
            message = "Error occurred while uploading the file";
        }

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }
	}


