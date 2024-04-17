package service;

import java.util.*;

import model.Product;
import model.Sale;
import model.Seller;

public class GenerateReports {

	public List<String> GenerateSalesReport(List<Sale> sales, List<Seller> sellers) {
		List<String> info = new ArrayList<>();

		Map<String, Integer> salesBySeller = new HashMap<>();

		// Obtener todos los vendedores registrados
		for (Seller seller : sellers) {
			salesBySeller.put(seller.getName(), 0);
		}

		// Sumar el monto de ventas a los vendedores
		for (Sale sale : sales) {
			String sellerName = sale.getSeller().getName();

			if (salesBySeller.containsKey(sellerName)) {
				salesBySeller.put(sellerName, salesBySeller.get(sellerName) + sale.getCollected());
			}
		}

		// Ordenar por monto de venta de mayor a menor
		List<Map.Entry<String, Integer>> salesBySeller2 = new ArrayList<>(salesBySeller.entrySet());
		Collections.sort(salesBySeller2, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		// Adicionar el encabezado, a la lista de
		info.add("VENDEDOR; RECAUDO EN VENTAS");

		// Organizar la información de vendedores y monto, separados por formato csv
		// (separado por coma)
		for (Map.Entry<String, Integer> entry : salesBySeller2) {
			info.add(entry.getKey() + ";" + entry.getValue());
		}

		return info;
	}

	public List<String> GenerateSalesFile(List<Sale> sales) {
		List<String> info = new ArrayList<>();
		// Adicionar el encabezado, a la lista de
		info.add("PRODUCTO; VENDERO; CANTIDAD");
		// Organizar la información, separados por formato csv (separado por coma)
		for (Sale sale : sales) {
			info.add(sale.getProduct().getName() + ";" + sale.getSeller().getName()+" "+sale.getSeller().getLastname() + ";" + sale.getQuantity());
		}

		return info;
	}

	public List<String> GenerateProductsFile(List<Product> products) {
		List<String> info = new ArrayList<>();
		// Adicionar el encabezado, a la lista de
		info.add("ID; NOMBRE; PRECIO");
		// Organizar la información, separados por formato csv (separado por coma)
		for (Product product : products) {
			info.add(product.getId() + ";" + product.getName() + ";" + product.getPrice());
		}
		return info;
	}

	public List<String> GenerateSalesManInfoFile(List<Seller> sellers) {
		List<String> info = new ArrayList<>();
		// Adicionar el encabezado, a la lista de
		info.add("ID; NOMBRE; APELLIDO; DOCUMENTO");
		// Organizar la información, separados por formato csv (separado por coma)
		for (Seller seller : sellers) {
			info.add(seller.getId() + ";" + seller.getName() + ";" + seller.getLastname() + ";" + seller.getDocument());
		}
		return info;
	}
}