package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixOperationsManager {

	public static Integer[][] readFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		int matrixDimension = 0;
		int skip = 1;
		while(scanner.hasNextInt() && skip == 1) { //This in kinda dumb, just to get the matrix dimension LMAO
			matrixDimension = scanner.nextInt();
			skip++;
		}
		
		if(matrixDimension < 8 && matrixDimension > 16) {
			imprimirMensaje("Matrix dimension can't be less than 8 or greater than 16");
			scanner.close();
			System.exit(0);
		}
		
		Integer[][] integersArray = new Integer[matrixDimension][matrixDimension];
		for(int i = 0; i < integersArray.length; i++) {
			for(int j = 0; j < integersArray[i].length; j++) {
				if(scanner.hasNextInt()) 
					integersArray[i][j] = scanner.nextInt();
				else
					integersArray[i][j] = 0;
			}
		}
		imprimirMensaje("La dimensión de la matriz es " + matrixDimension + "\n");
		scanner.close();
		return integersArray;
	}
	
	public static void mostrarMatriz(Integer[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			imprimirMensaje("");
		}
	}
	
	public static int sumarDatos(Integer[][] array) {
		int totalSuma = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				totalSuma += array[i][j];
			}
		}
		return totalSuma;
	}
	
	public static void devolverMayor(Integer[][] array) {
		int mayor = array[0][0];
		int fila = 0;
		int columna = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] > mayor) {
					mayor = array[i][j];
					fila = i;
					columna = j;
				}
			}
		}
		imprimirMensaje("El número mayor está en la posición [" + fila + "][" + columna + "] con el valor " + mayor);
	}
	
	public static void devolverMenor(Integer[][] array) {
		int menor = array[0][0];
		int fila = 0;
		int columna = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] < menor) {
					menor = array[i][j];
					fila = i;
					columna = j;
				}
			}
		}
		imprimirMensaje("El número menor está en la posición [" + fila + "][" + columna + "] con el valor " + menor);
	}
	
	public static void mostrarVector(Integer[] array) {
		String respuesta = "[";
		for(int i = 0; i < array.length; i++) {
			respuesta += (array[i] + ", ");
		}
		if(respuesta.endsWith(", ")) {
			respuesta = respuesta.substring(0, respuesta.length() - 2);
		} else if(respuesta.endsWith(",")) {
			respuesta = respuesta.substring(0, respuesta.length() - 1);
		}
		respuesta += "]";
		imprimirMensaje(respuesta);
	}
	
	public static int menorDelVector(Integer[] array) {
		int menor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	public static int mayorDelVector(Integer[] array) {
		int mayor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < mayor) {
				mayor = array[i];
			}
		}
		return mayor;
	}
	
	public static void vectorConMenorPorFila(Integer[][] array) {
		Integer[] respuesta = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			Integer[] newArray = new Integer[array[i].length];
			for(int j = 0; j < array[i].length; j++) {
				newArray[j] = array[i][j];
			}
			respuesta[i] = menorDelVector(newArray);
		}
		mostrarVector(respuesta);
	}
	
	public static void vectorConMayorPorColumna(Integer[][] array) {
		Integer[] respuesta = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			Integer[] newArray = new Integer[array[i].length];
			for(int j = 0; j < array[i].length; j++) {
				newArray[j] = array[j][i];
			}
			respuesta[i] = menorDelVector(newArray);
		}
		mostrarVector(respuesta);
	}
	
	public static void muestraDatoConMayorSumaDigitosPorColumna(Integer[][] array) {
		List<String> respuestas = new ArrayList<String>();
		for(int i = 0; i < array.length; i++) {
			int mayorSumaDeDigitos = 0;
			int aux = 0;
			for(int j = 0; j < array[i].length; j++) {
				aux = array[j][i];
				int sumaDeDigitos = 0;
				int digitos = Integer.toString(aux).length();
				for(int k = 0; k < digitos; k++) {
					sumaDeDigitos = sumaDeDigitos + (aux % 10);
					aux = aux / 10;
				}
				
				if(sumaDeDigitos > mayorSumaDeDigitos) {
					mayorSumaDeDigitos = sumaDeDigitos;
				}
			}
			
			for(int j = 0; j < array[i].length; j++) {
				aux = array[j][i];
				int sumaDeDigitos = 0;
				int digitos = Integer.toString(aux).length();
				for(int k = 0; k < digitos; k++) {
					sumaDeDigitos = sumaDeDigitos + (aux % 10);
					aux = aux / 10;
				}
				
				if(sumaDeDigitos >= mayorSumaDeDigitos) {
					respuestas.add("La mayor suma de dígitos de la columna " + (i + 1) + " es " + mayorSumaDeDigitos + " en la posición [" + (i + 1) + "][" + (j + 1) + "]");
				}
			}
		}
		for(String respuesta : respuestas) {
			imprimirMensaje(respuesta);
		}
	}
	
	public static Integer[] pasarDeMatrizAVector(Integer[][] array) {
		Integer[] newArray = new Integer[array.length * array.length];
		int k = 0;
		for(int i = 0 ; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				newArray[k] = array[i][j];
				k++;
			}
		}
		return newArray;
	}
	
	public static Integer[][] pasarDeVectorAMatriz(Integer[] array){
		int dimension = (int) Math.sqrt(array.length);
		Integer[][] newArray = new Integer[dimension][dimension];
		int k = 0;
		for(int i = 0; i < dimension; i++) {
			for(int j = 0; j < dimension; j++) {
				 newArray[i][j] = array[k];
				 k++;
			}
		}
		return newArray;
	}
	
	public static Integer[] ordenarVectorPorBurbuja(Integer[] array) {
		for (int i = 0; i < (array.length - 1); i++) {
            for (int j = 0; j < (array.length - i - 1); j++) {
                if (array[j] > array[j+1]) 
                {
                	int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                }
			}
		}
		return array;
	}
	
	public static void ordenaCadaColumnaAscendentemente(Integer[][] array) { //método burbuja
		for(int i = 0; i < array.length; i++) {
			Integer[] columna = new Integer[array.length];
			for(int j = 0; j < array[i].length; j++) {
				columna[j] = array[j][i];
			}
			columna = ordenarVectorPorBurbuja(columna);
			for(int j = 0; j < array[i].length; j++) {
				array[j][i] = columna[j];
			}
		}
		mostrarMatriz(array);
	}
	
	public static void promedioDiagonalSecundaria(Integer[][] array) {
		int sumaDiagonalSecundaria = 0;
		int contador = 0;
		for(int i = (array.length - 1); i >= 0; i--) {
			for(int j = 0; j < array.length; j++) {
				if((i + j) == (array.length - 1)) {
					sumaDiagonalSecundaria += array[i][j];
					contador++;
				}
			}
		}
		double promedioDiagonalSecundaria = (double) sumaDiagonalSecundaria / contador;
		imprimirMensaje("El promedio de la diagonal secundaria es " + promedioDiagonalSecundaria);
	}
	
	public static void ordenaDescendentementePorColumnasTodaLaMatriz(Integer[][] array) { //método de inserción
		
	}
	
	public static void mostrarPorFilasTriangularSuperiorDerecha() {
		
	}
	
	public static void ordenarAscendentementePorColumna1() { //método burbuja mejorado
		
	}
	
	public static void intercambiarColumnas(Integer[][] array, int columna1, int columna2) {
		imprimirMensaje("Intercambiando columnas " + columna1 + " y " + columna2);
		for(int i = 0; i < array.length; i++) {
			int aux = array[i][columna1 - 1];
			array[i][columna1 - 1] = array[i][columna2 - 1];
			array[i][columna2 - 1] = aux;
		}
		mostrarMatriz(array);
	}
	
	public static boolean esPrimo(Integer numero) {
		int contador = 0;
		for(int i = 1; i <= numero; i++) {
			if(numero % i == 0) {
				contador++;
			}
		}
		return (contador <= 2);
	}
	
	public static void datosQueSeanPrimos(Integer[][] array) { //fila, columna, valor
		List<String> respuestas = new ArrayList<String>();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(esPrimo(array[i][j])) {
					String respuesta = "En la fila " + (i + 1) + " columna " + (j + 1) + " está el número primo " + array[i][j];
					respuestas.add(respuesta);
				}
			}
		}
		if(respuestas.size() > 0) {
			for(String respuesta : respuestas) {
				imprimirMensaje(respuesta);
			}
		} else {
			imprimirMensaje("No hay números primos en la matriz");
		}
	}
	
	public static void imprimirMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
