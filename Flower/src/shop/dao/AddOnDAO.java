package shop.dao;

public class AddOnDAO {
	
	private int productAddOnId;
	private int productID;
	private String productAddOnImage;
	private String productAddOnName;
	private int productAddOnPrice;
	private String prodcutAddOnDesc;
	private int cartSelectedFlag;
	
	public int getProductAddOnId() {
		return productAddOnId;
	}
	public void setProductAddOnId(int productAddOnId) {
		this.productAddOnId = productAddOnId;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductAddOnImage() {
		return productAddOnImage;
	}
	public void setProductAddOnImage(String productAddOnImage) {
		this.productAddOnImage = productAddOnImage;
	}
	public String getProductAddOnName() {
		return productAddOnName;
	}
	public void setProductAddOnName(String productAddOnName) {
		this.productAddOnName = productAddOnName;
	}
	public int getProductAddOnPrice() {
		return productAddOnPrice;
	}
	public void setProductAddOnPrice(int productAddOnPrice) {
		this.productAddOnPrice = productAddOnPrice;
	}
	public String getProdcutAddOnDesc() {
		return prodcutAddOnDesc;
	}
	public void setProdcutAddOnDesc(String prodcutAddOnDesc) {
		this.prodcutAddOnDesc = prodcutAddOnDesc;
	}
	public int getCartSelectedFlag() {
		return cartSelectedFlag;
	}
	public void setCartSelectedFlag(int cartSelectedFlag) {
		this.cartSelectedFlag = cartSelectedFlag;
	}
	
}

