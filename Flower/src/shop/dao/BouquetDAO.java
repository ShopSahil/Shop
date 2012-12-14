package shop.dao;

public class BouquetDAO {

	private Integer productID;
	private String productName;
	private String productLongDesc; 
	private String productImage;
	private String  occasionName;
	private Integer productPrice;
	private Integer productTypeId;
	private Integer occasionID;
	private Integer productOriginalPrice;
	private int moneySaved;
	private int productQuantity;
		
	
	
		public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

		public int getMoneySaved() {
		return moneySaved;
	}

	public void setMoneySaved(int moneySaved) {
		this.moneySaved = moneySaved;
	}

	public Integer getProductOriginalPrice() {
		return productOriginalPrice;
	}

	public void setProductOriginalPrice(Integer productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
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

	public String getProductLongDesc() {
		return productLongDesc;
	}

	public void setProductLongDesc(String productLongDesc) {
		this.productLongDesc = productLongDesc;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getOccasionName() {
		return occasionName;
	}

	public void setOccasionName(String occasionName) {
		this.occasionName = occasionName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Integer getOccasionID() {
		return occasionID;
	}

	public void setOccasionID(Integer occasionID) {
		this.occasionID = occasionID;
	}


}
