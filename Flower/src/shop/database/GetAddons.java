package shop.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dao.AddOnDAO;
import shop.dao.HomepageDAO;

public class GetAddons {

	
	// get all add-on products for a product
	
	
	public List<AddOnDAO> getAddAsPerProd(int prodId){
		List<AddOnDAO> addOns= new ArrayList<AddOnDAO>();
		String getAddOn = "select * from productaddon where productID="+prodId;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {

			
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(getAddOn);
			rs = st.executeQuery();
			while(rs.next()){
				AddOnDAO addOnDAO= new AddOnDAO();
				int productAddOnId = rs.getInt(1);
				String productAddOnImage = rs.getString(3);
				String productAddOnName = rs.getString(4);
				int productAddOnPrice = rs.getInt(5);
				String prodcutAddOnDesc = rs.getString(6);

				addOnDAO.setProductAddOnId(productAddOnId);
				addOnDAO.setProductAddOnImage(productAddOnImage != null
						&& !productAddOnImage.trim().equalsIgnoreCase("") ? productAddOnImage
						: "");
				addOnDAO.setProductAddOnName(productAddOnName != null
						&& !productAddOnName.trim().equalsIgnoreCase("") ? productAddOnName
						: "");
				addOnDAO.setProductAddOnPrice(productAddOnPrice);
				addOnDAO.setProdcutAddOnDesc(productAddOnName != null
						&& !prodcutAddOnDesc.trim().equalsIgnoreCase("") ? prodcutAddOnDesc
						: "");

				
				addOns.add(addOnDAO);
			}
		 }catch (SQLException e) {
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
			}
		
		return addOns;
	
	}

//get just on add-on as per its ID
	
	public AddOnDAO getAddOn(int addONId){
		
		String getAddOn = "select * from productaddon where productAddOnId="+addONId;

		AddOnDAO addOnDAO= new AddOnDAO();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {
	
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(getAddOn);
			rs = st.executeQuery();
			while(rs.next()){
						int productAddOnId = rs.getInt(1);
				String productAddOnImage = rs.getString(3);
				String productAddOnName = rs.getString(4);
				int productAddOnPrice = rs.getInt(5);
				String prodcutAddOnDesc = rs.getString(6);

				addOnDAO.setProductAddOnId(productAddOnId);
				addOnDAO.setProductAddOnImage(productAddOnImage != null
						&& !productAddOnImage.trim().equalsIgnoreCase("") ? productAddOnImage
						: "");
				addOnDAO.setProductAddOnName(productAddOnName != null
						&& !productAddOnName.trim().equalsIgnoreCase("") ? productAddOnName
						: "");
				addOnDAO.setProductAddOnPrice(productAddOnPrice);
				addOnDAO.setProdcutAddOnDesc(productAddOnName != null
						&& !prodcutAddOnDesc.trim().equalsIgnoreCase("") ? prodcutAddOnDesc
						: "");

				
				
			}
		 }catch (SQLException e) {
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
			}
		
		return addOnDAO;
	
	}
		
//get addon as per product ID and add on ID
	
	
	public List<AddOnDAO> getAddOnProdandAddID(int prodId, String delimitedaddOnIds){
		List<AddOnDAO> addOns= new ArrayList<AddOnDAO>();
		
		String getAddOn = "select * from productaddon where productID="+prodId +" and productAddOnId in("+delimitedaddOnIds+")";
		
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {

			
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(getAddOn);
			System.out.println(st.toString());
			rs = st.executeQuery();
			while(rs.next()){
				AddOnDAO addOnDAO= new AddOnDAO();
				int productAddOnId = rs.getInt(1);
				String productAddOnImage = rs.getString(3);
				String productAddOnName = rs.getString(4);
				int productAddOnPrice = rs.getInt(5);
				String prodcutAddOnDesc = rs.getString(6);

				addOnDAO.setProductAddOnId(productAddOnId);
				addOnDAO.setProductAddOnImage(productAddOnImage != null
						&& !productAddOnImage.trim().equalsIgnoreCase("") ? productAddOnImage
						: "");
				addOnDAO.setProductAddOnName(productAddOnName != null
						&& !productAddOnName.trim().equalsIgnoreCase("") ? productAddOnName
						: "");
				addOnDAO.setProductAddOnPrice(productAddOnPrice);
				addOnDAO.setProdcutAddOnDesc(productAddOnName != null
						&& !prodcutAddOnDesc.trim().equalsIgnoreCase("") ? prodcutAddOnDesc
						: "");

				
				addOns.add(addOnDAO);
			}
		 }catch (SQLException e) {
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
			}
		
		return addOns;
	
	}

	
	public List<AddOnDAO> getAddOnProdandAddIDCart(int prodId, String delimitedaddOnIds){
		List<AddOnDAO> addOns= new ArrayList<AddOnDAO>();
		
		String getAddOn = "select * from productaddon where productID="+prodId +" and productAddOnId in("+delimitedaddOnIds+")";
		
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {

			
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(getAddOn);
			System.out.println(st.toString());
			rs = st.executeQuery();
			while(rs.next()){
				AddOnDAO addOnDAO= new AddOnDAO();
				int productAddOnId = rs.getInt(1);
				String productAddOnImage = rs.getString(3);
				String productAddOnName = rs.getString(4);
				int productAddOnPrice = rs.getInt(5);
				String prodcutAddOnDesc = rs.getString(6);

				addOnDAO.setProductAddOnId(productAddOnId);
				addOnDAO.setProductAddOnImage(productAddOnImage != null
						&& !productAddOnImage.trim().equalsIgnoreCase("") ? productAddOnImage
						: "");
				addOnDAO.setProductAddOnName(productAddOnName != null
						&& !productAddOnName.trim().equalsIgnoreCase("") ? productAddOnName
						: "");
				addOnDAO.setProductAddOnPrice(productAddOnPrice);
				addOnDAO.setProdcutAddOnDesc(productAddOnName != null
						&& !prodcutAddOnDesc.trim().equalsIgnoreCase("") ? prodcutAddOnDesc
						: "");
				addOnDAO.setCartSelectedFlag(1);
				
				addOns.add(addOnDAO);
			}
		 }catch (SQLException e) {
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
			}
		
		return addOns;
	
	}


}
