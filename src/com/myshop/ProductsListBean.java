package com.myshop;

public class ProductsListBean {

	private String ProductName;
	private String ProductImageURL;
	private String ProductPrice;
	private String ProductCat;
	private String Quantity;
	private String CurrentSession;
	private String Cart_ID;
	private String Total_price;
	private String UserId;
	private String ProductCategoryName;
	private String ProductCategoryImageURL;
	private String  Manufacturer;
	private String  Product_Category_ID;

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String newProductName) {
		ProductName = newProductName;
	}

	public String getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(String newProductPrice) {
		ProductPrice = newProductPrice;
	}

	public void setProductCat(String newProductCat) {
		ProductCat = newProductCat;
	}

	public String getProductCat() {
		return ProductCat;
	}

	public String getProductImageURL() {
		return ProductImageURL;
	}

	public void setProductImageURL(String productImageURL) {
		ProductImageURL = productImageURL;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getCart_ID() {
		return Cart_ID;
	}

	public void setCart_ID(String cart_ID) {
		Cart_ID = cart_ID;
	}

	public String getTotal_price() {
		return Total_price;
	}

	public void setTotal_price(String total_price) {
		Total_price = total_price;
	}

	public String getCurrentSession() {
		return CurrentSession;
	}

	public void setCurrentSession(String currentSession) {
		CurrentSession = currentSession;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public void setValid(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	   public String getProductCategoryName() {
	       return ProductCategoryName;
		}

	    public void setProductCategoryName(String newProductCategoryName) {
	    	ProductCategoryName = newProductCategoryName;
		}

		
	    public String getProductCategoryImageURL() {
	       return ProductCategoryImageURL;
				}

	    public void setProductCategoryImageURL(String newProductCategoryImageURL) {
	    	ProductCategoryImageURL = newProductCategoryImageURL;
				}

		public String getManufacturer() {
			return Manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			Manufacturer = manufacturer;
		}

		public String getProduct_Category_ID() {
			return Product_Category_ID;
		}

		public void setProduct_Category_ID(String product_Category_ID) {
			Product_Category_ID = product_Category_ID;
		}
			

}