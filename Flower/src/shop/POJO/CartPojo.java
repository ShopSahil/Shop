package shop.POJO;

import java.util.ArrayList;
import java.util.List;

import shop.dao.AddOnDAO;
import shop.dao.BouquetDAO;

public class CartPojo {
	private int uniqueID;
	
	private Integer productID;
	private String productName;
	private String productImage;
	private Integer productPrice;
	private int productQuantity;
	private float finalPrice;
	private int quantity;
	private ArrayList<AddOnDAO> addOnDAO;
	private String deliveryDate;
	private int totalCost;
	private int TotalSaving;
	private double pincode;
	private String city;
	private String lane1;
	private String lane2;
	private int mobileNum;
	private String message;
	private String recipientName;
	
	
	
	
	
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public int getTotalSaving() {
		return TotalSaving;
	}
	public void setTotalSaving(int totalSaving) {
		TotalSaving = totalSaving;
	}
	public int getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
	public ArrayList<AddOnDAO> getAddOnDAO() {
		return addOnDAO;
	}
	public void setAddOnDAO(ArrayList<AddOnDAO> addOnDAO) {
		this.addOnDAO = addOnDAO;
	}
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public float getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPincode() {
		return pincode;
	}
	public void setPincode(double pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLane1() {
		return lane1;
	}
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	public String getLane2() {
		return lane2;
	}
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	public int getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(int mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	


}
