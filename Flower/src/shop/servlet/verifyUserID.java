package shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.database.DatabaseManager;

/**
 * Servlet implementation class for Servlet: verify
 *
 */
public class verifyUserID extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;
    private static final String charset = "!@#$%^&*()" +
            "0123456789" +
            "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String userPassword = "";

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public verifyUserID() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("action======"+request.getParameter("action"));	
		System.out.println("email id======"+request.getParameter("emailID"));	
		if (request.getParameter("action").equalsIgnoreCase("1")) {
		
			Boolean valid = this.validateUser(request.getParameter("emailID"),request.getParameter("password"));
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if(!valid){
			out.println("{\"error\":");
			out.println("\"Sahil \"}");}
			else{out.println("{\"success\":");
			out.println("\"success \"}");}
		}
		
		//validate if user exist in database or not
		if (request.getParameter("action").equalsIgnoreCase("2")) {
			
			Boolean valid = this.validateUser(request.getParameter("emailID"));
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			System.out.println("valid"+valid + !valid);
			if(!valid)
			{System.out.println("error");
				out.println("{\"error\":");
			out.println("\"Sahil \"}");
			}else{
				System.out.println("success");
				out.println("{\"success\":");
			out.println("\"success \"}");}
		}
		
		//generate new password in case of forgot password
		if (request.getParameter("action").equalsIgnoreCase("3")) {
			
			Boolean valid = this.updateUser(request.getParameter("emailID"));
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			System.out.println("valid"+valid + !valid);
			if(!valid)
			{
				System.out.println("error");
				out.println("{\"error\":");
				out.println("\"Sahil \"}");
			}
			else
			{
				System.out.println("success");
				out.println("{\"success\":");
				out.println("\"success \"}");
			}
		}		

	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("action======"+request.getParameter("action"));	
		System.out.println("email id======"+request.getParameter("emailID"));	
		this.doGet(request, response);
	}

	//validate existing user for log in
	@SuppressWarnings("finally")
	public boolean validateUser(String emailID, String Password) {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Boolean emailExist = false;

		if(emailID != null && emailID != "" && emailID.equalsIgnoreCase(emailID)){
			
			String checkValid = "select email from userinfo where email='" + emailID + "' And pass='" + Password + "'" ;

			try {
				conn = (Connection) DatabaseManager.getConnection();
				st = (PreparedStatement) conn.prepareStatement(checkValid);
				rs = st.executeQuery();
				if (rs.next()) {
				
					emailExist = true;
					return emailExist;
				}
				else{
					
					emailExist = false;
					return emailExist;
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
				return emailExist;
			}
			
		}
		else{
			
			return emailExist;
		}
	}

	@SuppressWarnings("finally")
	public boolean validateUser(String emailID) {


		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Boolean emailExist = false;

		if(emailID != null && emailID != "" && emailID.equalsIgnoreCase(emailID)){
			
			String checkExisting = "select email from userinfo where email='" + emailID + "'";

			try {
				conn = (Connection) DatabaseManager.getConnection();
				st = (PreparedStatement) conn.prepareStatement(checkExisting);
				rs = st.executeQuery();
				if (rs.next()) {
				
					emailExist = true;
					return emailExist;
				}
				else{
					
					emailExist = false;
					return emailExist;
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
				return emailExist;
			}
			
		}
		else{
			
			return emailExist;
		}
			

	}

	@SuppressWarnings("finally")
	public boolean updateUser(String emailID) {


		Connection conn = null;
		PreparedStatement st = null;
		Boolean passwordUpdated = false;
		
		int userID = getUserId(emailID);
		System.out.println("userID======"+userID);
		String newPassword = "";
			   newPassword = getNewPassword(10); 
			   userPassword = newPassword;
		System.out.println("newPassword======"+newPassword);
		
		if(emailID != null && emailID != "" && emailID.equalsIgnoreCase(emailID)){
			
			String updatePassword = "Update userinfo set pass = '" + newPassword + "' where userID = '" + userID + "'";

			try {
				conn = (Connection) DatabaseManager.getConnection();
				st = (PreparedStatement) conn.prepareStatement(updatePassword);
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
				return true;
			}
			
		}
		else{
			return false;

		}
			

	}
	
	@SuppressWarnings("finally")
	public int getUserId(String emailID) {


		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int userId = -1;

		if(emailID != null && emailID != "" && emailID.equalsIgnoreCase(emailID)){
			
			String checkExisting = "select userID from userinfo where email='" + emailID + "'";

			try {
				conn = (Connection) DatabaseManager.getConnection();
				st = (PreparedStatement) conn.prepareStatement(checkExisting);
				rs = st.executeQuery();
				if (rs.next()) {
				
					userId = rs.getInt(1);
					return userId;
				}
				else{
					
					userId = -1;
					return userId;
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
				return userId;
			}
			
		}
		else{
			
			return userId;
		}
			

	}	
	
	public static String getNewPassword(int length){
		
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= length; i++ ) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();		
		
	}
	
}
