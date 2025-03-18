package com.excel_proyect.excel_proyect.utils;

import org.apache.poi.ss.usermodel.*;

public class ExcelStyleHelper {
    // Método para crear estilo de cabecera (negrita y centrado)
    public static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THICK);
        return style;
    }

    // Método para crear estilo de celdas normales
    public static CellStyle createCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        return style;
    }

    // Método auxiliar para crear una celda con estilo
    public static void createCell(Row row, int column, String value, CellStyle style) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    // Método auxiliar para agregar una fila con datos
    public static void addRow(Sheet sheet, int rowIndex, String nombre, String edad, String ciudad, CellStyle style) {
        Row row = sheet.createRow(rowIndex);
        createCell(row, 1, nombre, style);
        createCell(row, 2, edad, style);
        createCell(row, 3, ciudad, style);
    }

}
