package shop.flower.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import shop.dao.HomepageDAO;
import shop.database.DatabaseManager;
import shop.flower.config.ConfigMangaer;

public class Index {

	ConfigMangaer cm = ConfigMangaer.getInstance();
	Properties p = cm.getProperties();

	String products = p.getProperty("productID.homepage");

	// private final String homepageData
	// ="select * from homeprod where productId in ("+products+")" ;
	private final String homepageData = "select p.productID ,p. productName , p. productShortDescrip , p.productImage , p.productOriginalPrice  , p.productDiscountedPrice , pt.productType ,p.productQuantity ,ps.productShippingPrice  from (( product p join productshipping ps ) join producttype pt ) where (( p.productTypeId  =  pt.productTypeID ) and ( p.productShippingTypeID  =  ps.productShippingTypeID ) and productID in ("
			+ products + "))";

	private String userID;
	private List<HomepageDAO> homepageList;

	public List<HomepageDAO> getHomepageList() {
		this.getProducts();
		return homepageList;
	}

	public void setHomepageList(List<HomepageDAO> homepageList) {
		this.homepageList = homepageList;
	}

	public Index() {
		super();
		userID = "";

	}

	public String getUserID() {

		return userID;
	}

	public void setUserID(String userID) {

		this.userID = userID;
		/* this.getProducts(); */
	}

	public void getProducts() {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {

			homepageList = new ArrayList<HomepageDAO>();
			conn = (Connection) DatabaseManager.getConnection();
			st = (PreparedStatement) conn.prepareStatement(homepageData);
			rs = st.executeQuery();
			while (rs.next()) {
				HomepageDAO homePageDAO = new HomepageDAO();
				int productID = rs.getInt(1);
				String productName = rs.getString(2);
				String productShortDescrip = rs.getString(3);
				String productImage = rs.getString(4);
				
				int productOrigPrice = rs.getInt(5);
				int productDiscPrice = rs.getInt(6);
				String productType = rs.getString(7);
				int productQuantity = rs.getInt(8);
				int productShippingCost = rs.getInt(9);
				homePageDAO.setProductID(productID);
				homePageDAO.setProductName(productName);
				homePageDAO.setProductShortDescrip(productShortDescrip);
				homePageDAO.setProductImage(productImage);
				homePageDAO.setProductOrigPrice(productOrigPrice);
				homePageDAO.setProductDiscPrice(productDiscPrice);
				homePageDAO.setProductType(productType);
				homePageDAO.setProductQuantity(productQuantity);
				homePageDAO.setProductShippingCost(productShippingCost);

				homepageList.add(homePageDAO);

				System.out.println(homepageList.size());
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
		}

	}

}
