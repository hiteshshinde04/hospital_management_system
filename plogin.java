package com.hospdbms.pkg;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Plogin
 */
@WebServlet("/plogin")
public class plogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public plogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String driverName = "com.mysql.cj.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "hospital_database";
		String userId = "root";
		String password = "admin";
		String pwdd=null;
		String name=request.getParameter("uname");
	
		String psswd=request.getParameter("pwd");
		try {
			Class.forName(driverName);
			System.out.println("Connection done ");
			} catch (ClassNotFoundException e) {
				System.out.println("sadasd");
			e.printStackTrace();
			}

			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try{ 
				connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
				statement=connection.createStatement();
				String sql ="SELECT password FROM patients_info where name='"+name+"'";

				resultSet = statement.executeQuery(sql);
				if(resultSet.next()) {
				pwdd=resultSet.getString("password");
				
		if(psswd.equalsIgnoreCase(pwdd)) {
			session.setAttribute("Name",name);
			request.getRequestDispatcher("patientpage.jsp").forward(request, response);
				}
		}
	
		else {
			request.setAttribute("error", "Invalid username/password.");
			request.getRequestDispatcher("plogin.jsp").forward(request, response);
	}
	}catch(SQLException e) { 
		System.out.println("kkrk");
		e.printStackTrace();
	}
			}}
