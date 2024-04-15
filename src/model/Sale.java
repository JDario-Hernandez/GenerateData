package model;

public class Sale {

	private Product product;
	private Seller seller;
	private int quantity;
	private int collected;
	
	public Sale(Product product, Seller seller, int quantity) {
		super();
		this.product = product;
		this.seller = seller;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCollected() {
		return collected;
	}

	public void setCollected(int collected) {
		this.collected = collected;
	}	
}
