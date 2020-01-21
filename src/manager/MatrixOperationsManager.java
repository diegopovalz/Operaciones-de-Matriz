package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Diego Alejandro Poveda Alzate
 */
public class MatrixOperationsManager {
	/**
	  * Lee un archivo en una ruta espec�fica y crea una matriz
	  *
	  * @param ruta La ruta en donde se encuentra el archivo.
	  * @return La matriz si se logra leer el archivo-
	  */
	/*public static Integer[][] leerArchivo(String ruta) {
		FileReader reader = null;
		BufferedReader buffered = null;
		File file = new File(ruta);
		Integer matrixDimension = null;
		if(!file.exists()) {
			imprimirMensaje("�El archivo especificado no existe!\n");
		} else {
			try {
				reader = new FileReader(file);
				buffered = new BufferedReader(reader);
				matrixDimension = Integer.parseInt(buffered.readLine());
			} catch (FileNotFoundException e) {
				imprimirMensaje("�El archivo no fue encontrado!\n");
				e.printStackTrace();
			} catch (NumberFormatException e) {
				imprimirMensaje("�Hay un dato en el archivo que no se puede convertir a n�mero!\n");
				e.printStackTrace();
			} catch (IOException e) {
				imprimirMensaje("�Hay un error que no s� por qu� sale!\n");
				e.printStackTrace();
			}
		}
		imprimirMensaje("La dimensi�n de la matriz es " + matrixDimension);
		Integer[][] matrix = new Integer[matrixDimension][matrixDimension];
		String linea = null;
		try {
			linea = buffered.readLine();
			int contador = 0;
			while(linea != null) {
				String[] valores = linea.split(" ");
				for(int i = 0; i < valores.length; i++) {
					matrix[contador][i] = Integer.parseInt(valores[i]);
				}
				contador++;
				linea = buffered.readLine();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if(buffered != null) {
				try {
					buffered.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return matrix;
	}*/
	
	public static Integer[][] leerArchivo(String ruta) {
		File file = new File(ruta);
		Scanner scanner = null;
		if(!file.exists()) {
			imprimirMensaje("�No se ha encontrado el archivo!\n");
		} else {
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				imprimirMensaje("�Archivo no encontrado!\n");
				e.printStackTrace();
			}
		}
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
		imprimirMensaje("La dimensi�n de la matriz es " + matrixDimension + "\n");
		scanner.close();
		return integersArray;
	}
	
	/**
	 * Devuelve la cantidad de d�gitos del numero mayor de la matriz
	 * 
	 * @param array Matriz a la cual se buscar� el numero mayor
	 * @return La cantidad de d�gitos del numero mayor de la matriz
	 */
	public static Integer numeroDigitosNumeroMayor(Integer[][] array) {
		Integer numeroMayor = array[0][0];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] > numeroMayor) {
					numeroMayor = array[i][j];
				}
			}
		}
		return Integer.toString(numeroMayor).length();
	}
	
	/**
	 * Imprime la matriz
	 * @param array Matriz a imprimir
	 */
	public static void mostrarMatriz(Integer[][] array) {
		Integer digitosMaximos = numeroDigitosNumeroMayor(array);
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				Integer espaciosFaltantes = digitosMaximos - Integer.toString(array[i][j]).length();
				String espacios = "";
				for(int k = 0; k < espaciosFaltantes; k++) {
					espacios += " ";
				}
				imprimirSinSalto(espacios + array[i][j] + " ");
			}
			imprimirMensaje("");
		}
		imprimirMensaje("\n");
	}
	
	/**
	 * Suma todos los datos de la matriz y se imprime el resultado
	 * @param array Matriz a la cual se le sumar�n sus datos
	 */
	public static void sumarDatos(Integer[][] array) {
		int totalSuma = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				totalSuma += array[i][j];
			}
		}
		imprimirMensaje("La suma total de datos es: " + totalSuma + "\n");
	}
	
	/**
	 * Devuelve el n�mero m�s grande que hay en la matriz
	 * @param array Matriz a la cual se le devolver� el n�mero mayor en ella
	 */
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
		imprimirMensaje("El n�mero mayor est� en la posici�n [" + (fila + 1) + "][" + (columna + 1) + "] con el valor " + mayor + "\n");
	}
	
	/**
	 * Devuelve el n�mero m�s peque�o que hay en la matriz
	 * @param array Matriz a la cual se le devolver� el n�mero menor en ella
	 */
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
		imprimirMensaje("El n�mero menor est� en la posici�n [" + (fila + 1) + "][" + (columna + 1) + "] con el valor " + menor + "\n");
	}
	
	/**
	 * Imprime una respuesta en forma de vector
	 * @param array Vector con el que se conseguir�n los datos a imprimir
	 */
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
		imprimirMensaje(respuesta + "\n");
	}
	
	/**
	 * Imprime una respuesta en forma de vector
	 * @param array Vector con el que se conseguir�n los datos a imprimir
	 * @param extra Informaci�n extra que se quiere imprimir
	 * @param incluirIndice verdadero si quiere que se imprima el �ndice, falso si no
	 */
	public static void mostrarVector(Integer[] array, String extra, boolean incluirIndice) {
		String respuesta = "[";
		for(int i = 0; i < array.length; i++) {
			String indice = (incluirIndice ? Integer.toString(i + 1) : "");
			respuesta += (extra + indice + ": "+  + array[i] + ", ");
		}
		if(respuesta.endsWith(", ")) {
			respuesta = respuesta.substring(0, respuesta.length() - 2);
		} else if(respuesta.endsWith(",")) {
			respuesta = respuesta.substring(0, respuesta.length() - 1);
		}
		respuesta += "]";
		imprimirMensaje(respuesta + "\n");
	}
	
	/**
	 * Devuelve el n�mero menor que hay en el vector
	 * @param array Vector del cual se devolver� el n�mero menor
	 * @return El n�mero m�s peque�o del vector
	 */
	public static int menorDelVector(Integer[] array) {
		int menor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	/**
	 * Devuelve el n�mero mayor que hay en el vector
	 * @param array Vector del cual se devolver� el n�mero mayor
	 * @return El n�mero m�s grande del vector
	 */
	public static int mayorDelVector(Integer[] array) {
		int mayor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > mayor) {
				mayor = array[i];
			}
		}
		return mayor;
	}
	
	/**
	 * Imprime un vector indicando cual es el n�mero m�s peque�o de cada fila de la matriz
	 * @param array Matriz de la cual se sacar� la informaci�n
	 */
	public static void vectorConMenorPorFila(Integer[][] array) {
		Integer[] respuesta = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			Integer[] newArray = new Integer[array[i].length];
			for(int j = 0; j < array[i].length; j++) {
				newArray[j] = array[i][j];
			}
			respuesta[i] = menorDelVector(newArray);
		}
		mostrarVector(respuesta, "Menor de la fila ", true);
	}
	
	/**
	 * Imprime un vector indicando cual es el n�mero m�s grande de cada fila de la matriz
	 * @param array Matriz de la cual se sacar� la informaci�n
	 */
	public static void vectorConMayorPorColumna(Integer[][] array) {
		Integer[] respuesta = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			Integer[] newArray = new Integer[array[i].length];
			for(int j = 0; j < array[i].length; j++) {
				newArray[j] = array[j][i];
			}
			respuesta[i] = mayorDelVector(newArray);
		}
		mostrarVector(respuesta, "Mayor de la columna ", true);
	}
	
	/**
	 * Imprime cual es el mayor resultado de sumar los d�gitos de los n�meros de cada columna
	 * En caso de repetirse esta suma, se mostrar� en todas las posiciones que est�
	 * @param array Matriz de la cual se sacar� la informaci�n
	 */
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
					respuestas.add("La mayor suma de d�gitos de la columna " + (i + 1) + " es " + mayorSumaDeDigitos + " en la posici�n [" + (i + 1) + "][" + (j + 1) + "]");
				}
			}
		}
		for(String respuesta : respuestas) {
			imprimirMensaje(respuesta);
		}
		imprimirMensaje("\n");
	}
	
	/*//Estos dos m�todos no son necesarios ahora mismo, se dejar�n comentados hasta que haya necesidad de usarlos
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
	}*/
	
	/**
	 * Ordena un vector por el m�todo de ordenamiento burbuja
	 * @param array Vector a ordenar
	 * @return Vector ordenado
	 */
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
	
	/**
	 * Ordena cada columna de la matriz ascendentemente por el m�todo de ordenamiento burbuja
	 * @param array Matriz a la cual se le ordenar�n sus columnas
	 */
	public static void ordenaCadaColumnaAscendentemente(Integer[][] array) { //m�todo burbuja
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
	
	/**
	 * Devuelve el promedio de todos los n�meros ubicados en la diagonal secundaria de la matriz
	 * @param array Matriz que contiene una diagonal secundaria a la cual se le sacar� el promedio
	 */
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
		imprimirMensaje("El promedio de la diagonal secundaria es " + promedioDiagonalSecundaria + "\n");
	}
	
	/**
	 * Ordena la matriz de manera descendente por columnas
	 * @param array Matriz a ordenar
	 */
	public static void ordenaDescendentementePorColumnasTodaLaMatriz(Integer[][] array) { //m�todo de inserci�n
		
	}
	
	/**
	 * Muestra la matriz triangular superior ubicada dentro de la matriz original
	 * @param array Matriz original de la cual se mostrar� la matriz triangular superior
	 */
	public static void mostrarPorFilasTriangularSuperiorDerecha(Integer[][] array) {
		Integer digitosMaximos = numeroDigitosNumeroMayor(array);
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(i > j) 
					imprimirSinSalto("    ");
				else {
					Integer espaciosFaltantes = digitosMaximos - Integer.toString(array[i][j]).length();
					String espacios = "";
					for(int k = 0; k < espaciosFaltantes; k++) {
						espacios += " ";
					}
					imprimirSinSalto(espacios + array[i][j] + " ");
				}
			}
			imprimirMensaje(" ");
		}
	}
	
	/**
	 * Ordena ascendentemente la primera columna de la matriz
	 * @param array Matriz a la cual se le ordenar� ascendentemente la primera columna
	 */
	public static void ordenarAscendentementePorColumna1(Integer[][] array) { //m�todo burbuja mejorado
		
	}
	
	
	/**
	 * Intercambia dos columnas de una matriz
	 * @param array Matriz a la cual se le intercambiar�n las columnas
	 * @param columna1 Primera columna
	 * @param columna2 Segunda columna
	 */
	public static void intercambiarColumnas(Integer[][] array, int columna1, int columna2) {
		imprimirMensaje("Intercambiando columnas " + columna1 + " y " + columna2);
		for(int i = 0; i < array.length; i++) {
			int aux = array[i][columna1 - 1];
			array[i][columna1 - 1] = array[i][columna2 - 1];
			array[i][columna2 - 1] = aux;
		}
		mostrarMatriz(array);
	}
	
	/**
	 * Indica si un n�mero es primo o no
	 * @param numero N�mero a verificar
	 * @return <code>true</code> si es primo, <code>false</code> si no lo es
	 */
	public static boolean esPrimo(Integer numero) {
		int contador = 0;
		for(int i = 1; i <= numero; i++) {
			if(numero % i == 0) {
				contador++;
			}
		}
		return (contador <= 2);
	}
	
	/**
	 * Imprime los n�meros dentro de la matriz que sean primos, y su ubicaci�n
	 * @param array Matriz de la cual se revisar�n los n�meros primos
	 */
	public static void datosQueSeanPrimos(Integer[][] array) { //fila, columna, valor
		List<String> respuestas = new ArrayList<String>();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(esPrimo(array[i][j])) {
					String respuesta = "En la fila " + (i + 1) + " columna " + (j + 1) + " est� el n�mero primo " + array[i][j];
					respuestas.add(respuesta);
				}
			}
		}
		if(respuestas.size() > 0) {
			for(String respuesta : respuestas) {
				imprimirMensaje(respuesta);
			}
		} else {
			imprimirMensaje("No hay n�meros primos en la matriz\n");
		}
		imprimirMensaje("\n");
	}
	
	/**
	 * M�todo general para imprimir un mensaje
	 * @param mensaje Mensaje a imprimir
	 */
	public static void imprimirMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * M�todo general para imprimir un mensaje sin salto de l�nea
	 * @param mensaje Mensaje a imprimir
	 */
	public static void imprimirSinSalto(String mensaje) {
		System.out.print(mensaje);
	}
}
