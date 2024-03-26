package main;

import javax.swing.JOptionPane;

import model.Product;
import service.generateData;

public class GenerateInfoFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateData data = new generateData();

		data.addSeller(1, "Kevin", "Figueroa", "423131854");

		data.addProductoSold(1, "Televisor", 45000, 1);
		data.addProductoSold(2, "Nevera", 55000, 1);
		data.addProductoSold(3, "Celular", 435000, 1);

		data.addSeller(2, "Lorena", "Ortiz", "231318541");

		data.addProductoSold(4, "Televisor", 45000, 2);
		data.addProductoSold(5, "Nevera", 55000, 2);
		data.addProductoSold(6, "Celular", 435000, 2);

		data.addSeller(3, "Sebastian", "Serrato", "23131854615");

		data.addProductoSold(7, "Televisor", 45000, 3);
		data.addProductoSold(8, "Nevera", 55000, 3);
		data.addProductoSold(9, "Celular", 435000, 3);

		data.addSeller(4, "Jurgen", "Hernandez", "231214547");
		data.addProductoSold(10, "Televisor", 45000, 4);
		data.addProductoSold(11, "Nevera", 55000, 4);
		data.addProductoSold(12, "Celular", 435000, 4);
		String optionMenu = "";
		do {
			optionMenu = JOptionPane.showInputDialog(null,
					"Este es el menu de GenerateData por favor elija una opcion e ingresela\n" + "1 - Terminar\n"
							+ "2 - Agregar producto vendido\n" + "3 - Agregar vendedor\n"
							+ "4 - Ver productos vendidos por vendedor\n");
			switch (optionMenu) {
			case "2":
				String nameProduct = JOptionPane.showInputDialog(null, "escriba nombre del producto");
				String price = JOptionPane.showInputDialog(null, "escriba precio del producto");
				String idSeller = JOptionPane.showInputDialog(null, "escriba id del vendedor");

				data.addProductoSold(12, nameProduct, Integer.parseInt(price), Integer.parseInt(idSeller));
				break;
			case "3":
				String name = JOptionPane.showInputDialog(null, "escriba nombre del vendedor");
				String lastname = JOptionPane.showInputDialog(null, "escriba apellido del vendedor");	
				String document = JOptionPane.showInputDialog(null, "escriba documento del vendedor");

				data.addSeller(data.getSellers().size() + 1, name, lastname, document);
				break;
			case "4":
				String idSellerSelection = JOptionPane.showInputDialog(null, "escriba id del vendedor");
				String messageResponse = "";
				for (Product product : data.getProductos()) {
					if (product.getIdSeller() == Integer.parseInt(idSellerSelection)) {
						messageResponse += product.getName() + " - " + product.getPrice() + "\n";
					}
				}
				if (messageResponse.equalsIgnoreCase("")) {
					messageResponse = "Vendedor no tiene ventas";
				}
				JOptionPane.showMessageDialog(null, messageResponse);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Cierra Menu");
				optionMenu = "1";
				break;
			}
		} while (!optionMenu.equalsIgnoreCase("1"));

	}
}
