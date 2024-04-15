package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateFile {
		
	public String GenerateCsv (List<String> fileInfo, String filePath, String fileName) {
		try {
			FileWriter writer = new FileWriter(filePath + fileName);
			
			for (String info: fileInfo) {
				writer.append(info + "\n");
			}
						
			writer.flush();
			writer.close();
			
			return "El archivo" + fileName + " fue creado satisfactoriamente!";
		} catch (IOException e)	{
			return "Error generando archivo! " + e.getMessage();
		}
	}

}
