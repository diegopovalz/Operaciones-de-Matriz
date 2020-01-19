package service;

import java.io.File;
import java.io.FileNotFoundException;

import manager.MatrixOperationsManager;

public class MatrixOperationsService {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\POVEDA\\Desktop\\test.txt"); //Cambiar esta ruta por la que esté en su pc
		Integer[][] array = MatrixOperationsManager.readFile(file);
		MatrixOperationsManager.mostrarMatriz(array);
		System.out.println("");
		//int totalSuma = MatrixOperationsManager.sumarDatos(array); //Works!
		//MatrixOperationsManager.vectorConMenorPorFila(array); //Works!
		//MatrixOperationsManager.vectorConMayorPorColumna(array); //Works!
		//MatrixOperationsManager.muestraDatoConMayorSumaDigitosPorColumna(array); //Works!
		//MatrixOperationsManager.datosQueSeanPrimos(array); //Works!
		//MatrixOperationsManager.intercambiarColumnas(array, 1, 2); //Works!
		//MatrixOperationsManager.ordenaCadaColumnaAscendentemente(array); //Works!
		MatrixOperationsManager.promedioDiagonalSecundaria(array);
	}
}
