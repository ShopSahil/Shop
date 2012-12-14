package shop.flower.bean;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.dao.AddOnDAO;
import shop.dao.BouquetDAO;
import shop.database.DatabaseManager;

public class Bouquet {

	 private static final String getProduct = "select * from productPage where productID = ? ";
	private static String getAddOn = "select * from productaddon where productID= ?";
	private static String prodQuant="select * from productquantity where productID= ? ";
	private int productID;
	private List<AddOnDAO> addOnDAOs;
	private List<BouquetDAO> bouquetDAOs;
	private BouquetDAO bouquetDAO;

	public BouquetDAO getBouquetDAO() {
		return bouquetDAO;
	}

	public void setBouquetDAO(BouquetDAO bouquetDAO) {
		this.bouquetDAO = bouquetDAO;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
		this.getproductDetails();
	}

	public List<BouquetDAO> getBouquetDAOs() {
		return bouquetDAOs;
	}

	public void setBouquetDAOs(List<BouquetDAO> bouquetDAOs) {
		this.bouquetDAOs = bouquetDAOs;
	}

	public List<AddOnDAO> getAddOnDAOs() {
		return addOnDAOs;
	}

	public void setAddOnDAOs(List<AddOnDAO> addOnDAOs) {
		this.addOnDAOs = addOnDAOs;
	}

	public void getproductDetails() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		addOnDAOs = new ArrayList<AddOnDAO>();
		bouquetDAO = new BouquetDAO();

		try {
			conn = DatabaseManager.getConnection();

			pst =conn.prepareStatement(getProduct);
			pst.setInt(1,productID);
			rs = pst.executeQuery();
			while (rs.next()) {
				Integer productID = rs.getInt(1);
				String productName = rs.getString(2);
				String productLongDesc = rs.getString(3);
				String productImage = rs.getString(4);
				Integer productPrice = rs.getInt(5);
				Integer productOriginalPrice = rs.getInt(6);
				Integer productQuantity= rs.getInt(7);
				Integer productTypeId = rs.getInt(8);
				Integer occasionID = rs.getInt(9);
				String occasionName = rs.getString(10);
				System.out.println("productQuantity"+productQuantity);
				bouquetDAO.setProductID(productID);
				bouquetDAO
						.setProductName(productName != null
								&& !productName.trim().equalsIgnoreCase("") ? productName
								: "");
				bouquetDAO
						.setProductLongDesc(productLongDesc != null
								&& !productLongDesc.trim().equalsIgnoreCase("") ? productLongDesc
								: "");
				bouquetDAO
						.setProductImage(productImage != null
								&& !productImage.trim().equalsIgnoreCase("") ? productImage
								: "");
				bouquetDAO.setProductPrice(productPrice);
				bouquetDAO.setProductOriginalPrice(productOriginalPrice);
				bouquetDAO.setProductQuantity(productQuantity);
				bouquetDAO.setProductTypeId(productTypeId);
				bouquetDAO.setOccasionID(occasionID);
				bouquetDAO
						.setOccasionName(occasionName != null
								&& !occasionName.trim().equalsIgnoreCase("") ? occasionName
								: "");
				if (productOriginalPrice > productPrice) {
					bouquetDAO.setMoneySaved(productOriginalPrice
							- productPrice);
				} else {
					bouquetDAO.setMoneySaved(0);

				}

			}

			
			pst = conn.prepareStatement(getAddOn);
			pst.setInt(1, productID);
			rs = pst.executeQuery();
			while (rs.next()) {
				AddOnDAO addOnDAO = new AddOnDAO();

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

				addOnDAOs.add(addOnDAO);

			}

System.out.println(addOnDAOs.size());


			System.out.println(bouquetDAO.getProductID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
