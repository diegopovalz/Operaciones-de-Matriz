package service;

import manager.MatrixOperationsManager;

/**
 * @author Diego Alejandro Poveda Alzate
 */
public class MatrixOperationsService {

	public static void main(String[] args) {
		String ruta = "C:\\Users\\POVEDA\\Desktop\\test.txt";
		Integer[][] matriz = MatrixOperationsManager.leerArchivo(ruta);
		MatrixOperationsManager.mostrarMatriz(matriz);
		//MatrixOperationsManager.sumarDatos(matriz); //Works!
		//MatrixOperationsManager.devolverMayor(matriz); //Works!
		//MatrixOperationsManager.devolverMenor(matriz); //Works!
		//MatrixOperationsManager.vectorConMenorPorFila(matriz); //Works!
		//MatrixOperationsManager.vectorConMayorPorColumna(matriz); //Works!
		//MatrixOperationsManager.muestraDatoConMayorSumaDigitosPorColumna(matriz); //Works!
		//MatrixOperationsManager.ordenaCadaColumnaAscendentemente(matriz); //Works!
		//MatrixOperationsManager.promedioDiagonalSecundaria(matriz); //Works!
		//MatrixOperationsManager.mostrarPorFilasTriangularSuperiorDerecha(matriz); //Works!
		//MatrixOperationsManager.intercambiarColumnas(matriz, 2, 6); //Works!
		//MatrixOperationsManager.datosQueSeanPrimos(matriz); //Works!
		//MatrixOperationsManager.ordenaDescendentementePorColumnasTodaLaMatriz(matriz); //Works!
		//MatrixOperationsManager.ordenarAscendentementePorColumna1(matriz); //Works!
	}
}
