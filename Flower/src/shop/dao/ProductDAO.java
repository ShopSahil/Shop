package shop.dao;

public class ProductDAO {
	

private int productID;
private String productName;
private String productShortDescrip;
private String productdetailDescrip;
private int productOriginalPrice;
private String productImage;
private String productImageMedium;
private int productTypeId;
private int productShippingTypeID;
private int productDiscountedPrice;
private int productQuantity;



public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductShortDescrip() {
		return productShortDescrip;
	}
	public void setProductShortDescrip(String productShortDescrip) {
		this.productShortDescrip = productShortDescrip;
	}
	public String getProductdetailDescrip() {
		return productdetailDescrip;
	}
	public void setProductdetailDescrip(String productdetailDescrip) {
		this.productdetailDescrip = productdetailDescrip;
	}
	public int getProductOriginalPrice() {
		return productOriginalPrice;
	}
	public void setProductOriginalPrice(int productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductImageMedium() {
		return productImageMedium;
	}
	public void setProductImageMedium(String productImageMedium) {
		this.productImageMedium = productImageMedium;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public int getProductShippingTypeID() {
		return productShippingTypeID;
	}
	public void setProductShippingTypeID(int productShippingTypeID) {
		this.productShippingTypeID = productShippingTypeID;
	}
	public int getProductDiscountedPrice() {
		return productDiscountedPrice;
	}
	public void setProductDiscountedPrice(int productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}