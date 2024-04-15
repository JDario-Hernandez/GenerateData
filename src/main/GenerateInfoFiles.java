package main;

import java.util.List;

import javax.swing.JOptionPane;

import model.Product;
import model.Sale;
import service.*;

public class GenerateInfoFiles {

	public static void main(String[] args) {
		
		generateData data = new generateData();
		GenerateReports generateReports = new GenerateReports();
		GenerateFile generateFile = new GenerateFile();

		// Insertar Vendedores
		data.addSeller(1, "Kevin", "Figueroa", "423131854");
		data.addSeller(2, "Lorena", "Ortiz", "231318541");
		data.addSeller(3, "Sebastian", "Serrato", "23131854615");
		data.addSeller(4, "Jurgen", "Hernandez", "231214547");
		
		// Insertar Productos
		data.addProduct(1, "Televisor", 45000);
		data.addProduct(2, "Nevera", 55000);
		data.addProduct(3, "Celular", 435000);
			
		// Insertar Ventas
		data.addSale(1, "Televisor", 2);
		data.addSale(1, "Nevera", 1);
		data.addSale(1, "Celular", 3);
		
		data.addSale(2, "Televisor", 6);
		data.addSale(2, "Nevera", 2);
		data.addSale(2, "Celular", 3);
		
		data.addSale(3, "Televisor", 7);
		data.addSale(3, "Nevera", 1);
		data.addSale(3, "Celular", 2);
		
		data.addSale(4, "Televisor", 4);
		data.addSale(4, "Nevera", 2);
		data.addSale(4, "Celular", 5);
		
		String optionMenu = "";
		
		do {
			optionMenu = JOptionPane.showInputDialog(null,
					"Este es el menu de GenerateData por favor elija una opcion e ingresela\n" + "1 - Terminar\n"
							+ "2 - Agregar producto vendido\n" + "3 - Agregar vendedor\n"
							+ "4 - Ver productos vendidos por vendedor\n");
			
			switch (optionMenu) {
				case "2":
					String nameProduct = JOptionPane.showInputDialog(null, "escriba nombre del producto");
					String quantity = JOptionPane.showInputDialog(null, "Escriba la cantidad vendida");
					String idSeller = JOptionPane.showInputDialog(null, "escriba id del vendedor");
	
					data.addSale(Integer.parseInt(idSeller), nameProduct, Integer.parseInt(quantity));
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
					for (Sale sold : data.getSales()) {
						if (sold.getSeller().getId() == Integer.parseInt(idSellerSelection)) {
							messageResponse += sold.getProduct().getName() + " - " + sold.getCollected() + "\n";
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
		
		// Generar Archivo con el reporte
		List<String> infoReport = generateReports.GenerateSalesReport(data.getSales(), data.getSellers());
		String result = generateFile.GenerateCsv(infoReport, "", "Reporte_de_ventas_de_los_vendedores.csv");
		JOptionPane.showMessageDialog(null, result);

	}
}
