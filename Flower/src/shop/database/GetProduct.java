package shop.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dao.AddOnDAO;
import shop.dao.ProductDAO;
import shop.util.Utils;

public class GetProduct {
	// get a product on basis of product id
	public ProductDAO getProduct(int productId){
		
		ProductDAO productDAO = new ProductDAO();
		String getProduct = "select * from product where productID="+productId ;
		
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {

			
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(getProduct);
			rs = st.executeQuery();
			while(rs.next()){
				int productID=rs.getInt(1);
			String productName=rs.getString(2);
			String productShortDescrip=rs.getString(3);
			String productdetailDescrip=rs.getString(4);
			int productOriginalPrice=rs.getInt(5);
			String productImage=rs.getString(6);
			String productImageMedium=rs.getString(7);
			int productTypeId=rs.getInt(8);
			int productShippingTypeID=rs.getInt(9);
			int productDiscountedPrice=rs.getInt(10);
			int productQuantity=rs.getInt(11);
		
			
			productDAO.setProductID(productID);
			productDAO.setProductName(Utils.isEmptyThenReturn(productName, ""));
			productDAO.setProductShortDescrip(Utils.isEmptyThenReturn(productShortDescrip,""));
			productDAO.setProductdetailDescrip(Utils.isEmptyThenReturn(productdetailDescrip, ""));
			productDAO.setProductOriginalPrice(productOriginalPrice);
			productDAO.setProductImage(Utils.isEmptyThenReturn(productImage, ""));
			productDAO.setProductImageMedium(Utils.isEmptyThenReturn(productImageMedium, ""));
			productDAO.setProductTypeId(productTypeId);
			productDAO.setProductShippingTypeID(productShippingTypeID);
			productDAO.setProductDiscountedPrice(productDiscountedPrice);
			productDAO.setProductQuantity(productQuantity);}
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
		
		
		
		
		return productDAO;
	}

	public List<ProductDAO> getProduct(String productId){
		String getProduct = "select * from product where productID in ("+productId+")" ;

		List<ProductDAO> productDAOs= new ArrayList<ProductDAO>(); 
		
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(getProduct);
			rs = st.executeQuery();
			while(rs.next()){

				ProductDAO productDAO = new ProductDAO();
				
				int productID=rs.getInt(1);
			String productName=rs.getString(2);
			String productShortDescrip=rs.getString(3);
			String productdetailDescrip=rs.getString(4);
			int productOriginalPrice=rs.getInt(5);
			String productImage=rs.getString(6);
			String productImageMedium=rs.getString(7);
			int productTypeId=rs.getInt(8);
			int productShippingTypeID=rs.getInt(9);
			int productDiscountedPrice=rs.getInt(10);
			int productQuantity=rs.getInt(11);
		
			
			productDAO.setProductID(productID);
			productDAO.setProductName(Utils.isEmptyThenReturn(productName, ""));
			productDAO.setProductShortDescrip(Utils.isEmptyThenReturn(productShortDescrip,""));
			productDAO.setProductdetailDescrip(Utils.isEmptyThenReturn(productdetailDescrip, ""));
			productDAO.setProductOriginalPrice(productOriginalPrice);
			productDAO.setProductImage(Utils.isEmptyThenReturn(productImage, ""));
			productDAO.setProductImageMedium(Utils.isEmptyThenReturn(productImageMedium, ""));
			productDAO.setProductTypeId(productTypeId);
			productDAO.setProductShippingTypeID(productShippingTypeID);
			productDAO.setProductDiscountedPrice(productDiscountedPrice);
			productDAO.setProductQuantity(productQuantity);
			productDAOs.add(productDAO);
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
		
		
		
		
		return productDAOs;
	}

}
