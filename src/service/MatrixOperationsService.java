package service;

import java.util.Scanner;

import manager.MatrixOperationsManager;

/**
 * @author Diego Alejandro Poveda Alzate
 * @author Pedro Pablo Saldarriaga Jaramillo
 */
public class MatrixOperationsService {

	public static void main(String[] args) {
		String ruta = "src\\ArchivoMatriz.txt";
		System.out.println("Leyendo archivo. . .");
		Integer[][] matriz = MatrixOperationsManager.leerArchivo(ruta);
		System.out.println("Matriz resultante: ");
		MatrixOperationsManager.mostrarMatriz(matriz);
		String menu = "\nEscoge una de las siguientes opciones:\n" + 
					  "1. Sumar los datos de toda la matriz y mostrar el resultado\n" + 
					  "2. Mostrar el mayor n�mero de la matriz\n" + 
					  "3. Mostrar el menor n�mero de la matriz\n" + 
					  "4. Generar vector mostrando el n�mero menor en cada fila\n" + 
					  "5. Generar vector mostrando el n�mero mayor en cada columna\n" + 
					  "6. Mostrar el dato con la mayor suma de sus d�gitos, junto a su posici�n\n" + 
					  "7. Mostrar la matriz con cada columna ordenada ascendentemente\n" + 
					  "8. Mostrar el promedio de los datos de la diagonal secundaria de la matriz\n" + 
					  "9. Mostrar la matriz ordenada descendentemente por sus columnas\n" + 
					  "10. Mostrar la matriz triangular superior derecha de la matriz original\n" + 
					  "11. Mostrar la matriz con la primera columna ordenada ascendentemente\n" + 
					  "12. Intercambiar dos columnas\n" + 
					  "13. Mostrar los datos que sean primos, junto a su posici�n\n" + 
					  "0. Salir\n";
		System.out.println(menu);
		Scanner entrada = new Scanner(System.in);
		int opcion = entrada.nextInt();
		while(true) {
			switch(opcion) {
			case 1:
				MatrixOperationsManager.sumarDatos(matriz);
				break;
			case 2:
				MatrixOperationsManager.devolverMayor(matriz);
				break;
			case 3:
				MatrixOperationsManager.devolverMenor(matriz);
				break;
			case 4:
				MatrixOperationsManager.vectorConMenorPorFila(matriz);
				break;
			case 5:
				MatrixOperationsManager.vectorConMayorPorColumna(matriz);
				break;
			case 6:
				MatrixOperationsManager.muestraDatoConMayorSumaDigitosPorColumna(matriz);
				break;
			case 7:
				MatrixOperationsManager.ordenaCadaColumnaAscendentemente(matriz);
				break;
			case 8:
				MatrixOperationsManager.promedioDiagonalSecundaria(matriz);
				break;
			case 9:
				MatrixOperationsManager.ordenaDescendentementePorColumnasTodaLaMatriz(matriz);
				break;
			case 10:
				MatrixOperationsManager.mostrarPorFilasTriangularSuperiorDerecha(matriz);
				break;
			case 11:
				MatrixOperationsManager.ordenarAscendentementePorColumna1(matriz);
				break;
			case 12:
				System.out.println("Ingrese la primera columna");
				int columna1 = entrada.nextInt();
				System.out.println("Ingrese la segunda columna");
				int columna2 = entrada.nextInt();
				MatrixOperationsManager.intercambiarColumnas(matriz, columna1, columna2);
				break;
			case 13:
				MatrixOperationsManager.datosQueSeanPrimos(matriz);
				break;
			case 0:
				System.out.println("Abandonando aplicaci�n");
				entrada.close();
				System.exit(0);
				break;
			default:
				System.out.println("Escoja una opci�n entre 0 y 13\n");
				break;
			}
			System.out.println(menu);
			opcion = entrada.nextInt();
		}
	}
}
