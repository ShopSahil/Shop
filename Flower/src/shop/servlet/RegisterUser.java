package shop.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.HomepageDAO;
import shop.database.DatabaseManager;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("emailID======"+request.getParameter("emailID"));	
		System.out.println("Password======"+request.getParameter("password"));	
		Connection conn = null;
		PreparedStatement st = null;

		int newUserIndex = getUserIndex() + 1;

			
		String addNewUser = "Insert Into userinfo (email,pass,userID) values(?,?,?)";

		try {
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(addNewUser);
			st.setString(1, request.getParameter("emailID"));
			st.setString(2, request.getParameter("password"));
			st.setInt(3, newUserIndex);
			st.executeUpdate();

		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (st != null) {
					st.close();
				}

				
			} catch (Exception e) {
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.doGet(request, response);
	}
	
	@SuppressWarnings("finally")
	public int getUserIndex(){
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Boolean emailExist = false;
		int lastUserIndex = 0;
	
		String lastUserIndexQuery = "Select max(userID) from userinfo";

		try {
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(lastUserIndexQuery);
			rs = st.executeQuery();
			if (rs.next()) {
			
				lastUserIndex = rs.getInt(1);
				System.out.println("lastUserIndex======"+lastUserIndex);	
				return lastUserIndex;
			}
			else{
				
				lastUserIndex = 0;
				return lastUserIndex;
			}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
				
			} catch (Exception e) {
			}
			return lastUserIndex;
		}		
		
	}

}

