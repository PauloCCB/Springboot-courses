package com.excel_proyect.excel_proyect;


import com.excel_proyect.excel_proyect.utils.ExcelStyleHelper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static com.excel_proyect.excel_proyect.utils.ExcelStyleHelper.addRow;
import static com.excel_proyect.excel_proyect.utils.ExcelStyleHelper.createCell;

@SpringBootApplication
public class ExcelProyectApplication {

	public static void main(String[] args) {

		// 1) Crear un libro de Excel
		// Generando un archivo con extension .xlsx -> 2007 , ...
		Workbook libro = new XSSFWorkbook();

		// 1) Crear un libro de Excel
		// Generar un archivo con extension .xls ->1997 hasta la v. 2003
		//Workbook libro2 = new HSSFWorkbook();

		// 2) Crear las hojas
		Sheet hoja1 = libro.createSheet("Personas");

		// 3) Crear estilos usando la clase helper
		CellStyle headerStyle = ExcelStyleHelper.createHeaderStyle(libro);
		CellStyle cellStyle = ExcelStyleHelper.createCellStyle(libro);

		// 3) Crear las filas.
		// Fila 0 , empieza como si fuera un array


		Row cabecera = hoja1.createRow(2);

		createCell(cabecera, 1, "Nombre", headerStyle);
		createCell(cabecera, 2, "Edad", headerStyle);
		createCell(cabecera, 3, "Ciudad", headerStyle);


		addRow(hoja1, 3, "Santiago", "23", "Medellín", cellStyle);
		addRow(hoja1, 4, "Anyi", "22", "Bogotá", cellStyle);

		// 6) Ajustar tamaño de columnas automáticamente
		for (int i = 1; i <= 3; i++) {
			hoja1.autoSizeColumn(i);
		}


		// 7) Guardar el archivo
		try (OutputStream out = new FileOutputStream("ArchivoExcel.xlsx")) {
			libro.write(out);
			System.out.println("✅ Archivo Excel creado exitosamente: ArchivoExcel.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				libro.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



}
