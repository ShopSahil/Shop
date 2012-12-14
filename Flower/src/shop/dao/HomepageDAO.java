package shop.dao;

public class HomepageDAO {

	

	private int productID;
	private String productName;
	private String productShortDescrip;
	private int productOrigPrice;
	private String productImage;
	private String productType;
	private int productShippingCost;
	private int productDiscPrice;
	private int productQuantity;
	private String productImageMedium; 
	


	public HomepageDAO() {
		super();
		this.productID =0;
		this.productName ="";
		this.productShortDescrip ="";
		this.productShippingCost = 0;
		this.productImage = "";
		this.productDiscPrice = 0;
		this.productOrigPrice = 0;
		this.productType="";
		
	}
	
	
	
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


	public int getProductOrigPrice() {
		return productOrigPrice;
	}


	public void setProductOrigPrice(int productOrigPrice) {
		this.productOrigPrice = productOrigPrice;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public int getProductShippingCost() {
		return productShippingCost;
	}


	public void setProductShippingCost(int productShippingCost) {
		this.productShippingCost = productShippingCost;
	}


	public int getProductDiscPrice() {
		return productDiscPrice;
	}


	public void setProductDiscPrice(int productDiscPrice) {
		this.productDiscPrice = productDiscPrice;
	}

	
	public int getProductQuantity() {
		return productQuantity;
	}



	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}



	public String getProductImageMedium() {
		return productImageMedium;
	}



	public void setProductImageMedium(String productImageMedium) {
		this.productImageMedium = productImageMedium;
	}


	
	
	}
