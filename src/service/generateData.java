package service;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Seller;

public class generateData {
	private List<Seller> sellers;
	private List<Product> productos;

	public generateData() {
		sellers = new ArrayList<Seller>();
		productos = new ArrayList<Product>();
	}

	public List<Seller> getSellers() {
		return sellers;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void addSeller(int id, String name, String document) {
		Seller seller = new Seller();
		seller.setId(id);
		seller.setName(name);
		seller.setDocument(document);
		sellers.add(seller);
	}

	public void addProductoSold(int id, String name, int price, int idSeller) {
		Product product = new Product();
		product.setId(id);
		product.setIdSeller(idSeller);
		product.setName(name);
		product.setPrice(price);
		productos.add(product);
	}

}
