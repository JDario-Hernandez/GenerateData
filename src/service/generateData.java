package service;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Seller;
import model.Sale;

public class generateData {
	private List<Seller> sellers;
	private List<Product> products;
	private List<Sale> sales;

	public generateData() {
		sellers = new ArrayList<Seller>();
		products = new ArrayList<Product>();
		sales = new ArrayList<Sale>();
	}

	public List<Seller> getSellers() {
		return sellers;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public List<Sale> getSales() {
		return sales;
	}

	public void addSeller(int id, String name, String lastname, String document) {
		Seller seller = new Seller(id, name, lastname, document);
		sellers.add(seller);
	}

	public void addProduct(int id, String name, int price) {
		Product product = new Product(id, name, price);
		products.add(product);
	}
	
	public void addSale(int idSeller, String nameProduct, int quantity) {
		if (quantity == 0) return; // Si la cantidad de la venta fue 0, no se registra
		
		Product product = getProductByName(nameProduct);
		Seller seller = getSellerById(idSeller);
		
		// Buscar si el vendedor ya realizó una venta previa de ese producto
		for (Sale sale: sales ) {
			if (sale.getSeller().equals(seller) && sale.getProduct().equals(product)) {
				sale.setQuantity(sale.getQuantity() + quantity);
				sale.setCollected(sale.getCollected() + (quantity*product.getPrice()));
				return;
			}
		}
		
		Sale sale = new Sale(product, seller, quantity);
		sale.setQuantity(quantity);
		sale.setCollected(quantity*product.getPrice());
		
		sales.add(sale);
	}
	
	private Product getProductByName(String nameProduct) {
		for (Product product: products)	{
			if (product.getName().equals(nameProduct)) {
				return product;
			}
		}
		
		Product product = new Product(products.size(), nameProduct, 500000); // TODO: El precio del producto está estático
		return product;
	}
	
	private Seller getSellerById(int idSeller) {
		for (Seller seller: sellers)	{
			if (seller.getId() == idSeller) {
				return seller;
			}
		}
		
		return null;
	}

}

