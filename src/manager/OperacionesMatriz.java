package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Diego Alejandro Poveda Alzate
 */
public class OperacionesMatriz {
	/**
	  * Lee un archivo en una ruta específica y crea una matriz
	  *
	  * @param ruta La ruta en donde se encuentra el archivo.
	  * @return La matriz si se logra leer el archivo-
	  */
	public static Integer[][] leerArchivo(String ruta) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		Scanner scanner = null;
		try {
			fileReader = new FileReader(ruta);
			bufferedReader = new BufferedReader(fileReader);
			scanner = new Scanner(bufferedReader);
		} catch (FileNotFoundException e1) {
			imprimirMensaje("El archivo no existe o la ruta especificada no es correcta\n");
			System.exit(0);
		}
		int matrixDimension = scanner.nextInt();
		
		if(matrixDimension < 8 || matrixDimension > 16) {
			imprimirMensaje("¡ERROR! La dimensión de la matriz debe estar entre 8 y 16");
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
		if(scanner != null) {
			scanner.close();
		}
		return integersArray;
	}
	
	/**
	 * Devuelve la cantidad de dígitos del numero mayor de la matriz
	 * 
	 * @param array Matriz a la cual se buscará el numero mayor
	 * @return La cantidad de dígitos del numero mayor de la matriz
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
	}
	
	/**
	 * Suma todos los datos de la matriz y se imprime el resultado
	 * @param array Matriz a la cual se le sumarán sus datos
	 */
	public static void sumarDatos(Integer[][] array) {
		int totalSuma = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				totalSuma += array[i][j];
			}
		}
		imprimirMensaje("La suma total de datos es: " + totalSuma);
	}
	
	/**
	 * Devuelve el número más grande que hay en la matriz
	 * @param array Matriz a la cual se le devolverá el número mayor en ella
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
		imprimirMensaje("El número mayor está en la posición [" + (fila + 1) + "][" + (columna + 1) + "] con el valor " + mayor);
	}
	
	/**
	 * Devuelve el número más pequeño que hay en la matriz
	 * @param array Matriz a la cual se le devolverá el número menor en ella
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
		imprimirMensaje("El número menor está en la posición [" + (fila + 1) + "][" + (columna + 1) + "] con el valor " + menor);
	}
	
	/**
	 * Imprime una respuesta en forma de vector
	 * @param array Vector con el que se conseguirán los datos a imprimir
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
		imprimirMensaje(respuesta);
	}
	
	/**
	 * Imprime una respuesta en forma de vector
	 * @param array Vector con el que se conseguirán los datos a imprimir
	 * @param extra Información extra que se quiere imprimir
	 * @param incluirIndice verdadero si quiere que se imprima el índice, falso si no
	 */
	public static void mostrarVector(String[] array, String extra, boolean incluirIndice) {
		String respuesta = "[";
		for(int i = 0; i < array.length; i++) {
			String indice = (incluirIndice ? Integer.toString(i + 1) : "");
			respuesta += (extra + indice + ": " + array[i] + ", ");
		}
		if(respuesta.endsWith(", ")) {
			respuesta = respuesta.substring(0, respuesta.length() - 2);
		} else if(respuesta.endsWith(",")) {
			respuesta = respuesta.substring(0, respuesta.length() - 1);
		}
		respuesta += "]";
		imprimirMensaje(respuesta);
	}
	
	/**
	 * Devuelve el número menor que hay en el vector
	 * @param array Vector del cual se devolverá el número menor
	 * @return El número más pequeño del vector
	 */
	public static int menorDelVector(Integer[] array) {
		int menor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] <= menor) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	/**
	 * Imprime el menor de un vector con información adicional
	 * @param array Vector del cual se buscará el número menor
	 * @param info Información adicional
	 * @return Un String con el menor del vector e información extra
	 */
	public static String menorDelVector(Integer[] array, String info) {
		int menor = array[0];
		int extra = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] <= menor) {
				menor = array[i];
				extra = i;
			}
		}
		return menor + " en " + info + " " + (extra + 1);
	}
	
	/**
	 * Devuelve el número mayor que hay en el vector
	 * @param array Vector del cual se devolverá el número mayor
	 * @return El número más grande del vector
	 */
	public static int mayorDelVector(Integer[] array) {
		int mayor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= mayor) {
				mayor = array[i];
			}
		}
		return mayor;
	}
	
	/**
	 * Imprime el mayor de un vector con información adicional
	 * @param array Vector del cual se buscará el número mayor
	 * @param info Información adicional
	 * @return Un String con el mayor del vector e información extra
	 */
	public static String mayorDelVector(Integer[] array, String info) {
		int mayor = array[0];
		int extra = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= mayor) {
				mayor = array[i];
				extra = i;
			}
		}
		return mayor + " en " + info + " " + (extra + 1);
	}
	
	/**
	 * Imprime un vector indicando cual es el número más pequeño de cada fila de la matriz
	 * @param array Matriz de la cual se sacará la información
	 */
	public static void vectorConMenorPorFila(Integer[][] array) {
		String[] respuesta = new String[array.length];
		for(int i = 0; i < array.length; i++) {
			Integer[] newArray = new Integer[array[i].length];
			for(int j = 0; j < array[i].length; j++) {
				newArray[j] = array[i][j];
			}
			respuesta[i] = menorDelVector(newArray, "columna");
		}
		mostrarVector(respuesta, "Menor de la fila ", true);
	}
	
	/**
	 * Imprime un vector indicando cual es el número más grande de cada fila de la matriz
	 * @param array Matriz de la cual se sacará la información
	 */
	public static void vectorConMayorPorColumna(Integer[][] array) {
		String[] respuesta = new String[array.length];
		for(int i = 0; i < array.length; i++) {
			Integer[] newArray = new Integer[array[i].length];
			for(int j = 0; j < array[i].length; j++) {
				newArray[j] = array[j][i];
			}
			respuesta[i] = mayorDelVector(newArray, "fila");
		}
		mostrarVector(respuesta, "Mayor de la columna ", true);
	}
	
	/**
	 * Imprime cual es el mayor resultado de sumar los dígitos de los números de cada columna
	 * En caso de repetirse esta suma, se mostrará en todas las posiciones que esté
	 * @param array Matriz de la cual se sacará la información
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
					respuestas.add("La mayor suma de dígitos de la columna " + (i + 1) + " es " + mayorSumaDeDigitos + " en la posición [" + (i + 1) + "][" + (j + 1) + "]");
				}
			}
		}
		for(String respuesta : respuestas) {
			imprimirMensaje(respuesta);
		}
		imprimirMensaje("\n");
	}
	
	/**
	 * Convierte una matriz de dos dimensiones a un vector unidimensional
	 * @param array La matriz a convertir
	 * @return El vector de una dimensión
	 */
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
	
	/**
	 * Convierte un vector unidimensional a una matriz de dos dimensiones
	 * @param array El vector a convertir
	 * @param porColumnas <code>true</code> para llenar la matriz por columnas, <code>false</code> para llenarla por filas
	 * @return La matriz de dos dimensiones
	 */
	public static Integer[][] pasarDeVectorAMatriz(Integer[] array, boolean porColumnas){
		int dimension = (int) Math.sqrt(array.length);
		Integer[][] newArray = new Integer[dimension][dimension];
		if(porColumnas) {
			int k = array.length - 1;
			for(int i = 0; i < dimension; i++) {
				for(int j = 0; j < dimension; j++) {
					 newArray[j][i] = array[k];
					 k--;
				}
			}
		} else {
			int k = array.length - 1;
			for(int i = 0; i < dimension; i++) {
				for(int j = 0; j < dimension; j++) {
					 newArray[i][j] = array[k];
					 k--;
				}
			}
		}
		return newArray;
	}
	
	/**
	 * Ordena un vector por el método de ordenamiento burbuja
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
	 * Ordena un vector por el método de ordenamiento burbuja mejorado
	 * @param array Vector a ordenar
	 * @param desc <code>true</code> para ordenar el vector descendentemente, <code>false</code> para ordenarlo ascendentemente
	 * @return
	 */
	public static Integer[] ordenarVectorPorBurbujaMejorado(Integer[] array, boolean desc) {
		int bandera = 1;
		for(int i = 0; i < array.length - 1 && bandera == 1; i++) {
			bandera = 0;
			for(int j = 0; j < array.length - 1; j++){
				if(array[j] > array[j + 1]) {
					bandera = 1;
					Integer aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
			}
		}
		if(desc) {
			return invertirVector(array);
		} else {
			return array;
		}
	}
	
	/**
	 * Ordena cada columna de la matriz ascendentemente por el método de ordenamiento burbuja
	 * @param array Matriz a la cual se le ordenarán sus columnas
	 */
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
	
	/**
	 * Devuelve el promedio de todos los números ubicados en la diagonal secundaria de la matriz
	 * @param array Matriz que contiene una diagonal secundaria a la cual se le sacará el promedio
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
		imprimirMensaje("El promedio de la diagonal secundaria es " + promedioDiagonalSecundaria);
	}
	
	/**
	 * Ordena un vector usando el método de ordenamiento por inserción
	 * @param array El vector a ordenar
	 * @param desc <code>true</code> para ordenar descendentemente, <code>false</code> para ordenar ascendentemente
	 * @return El vector ordenado
	 */
	public static Integer[] ordenarVectorPorInsercion(Integer[] array, boolean desc) {
		for (int i = 1; i < array.length; ++i) { 
            int aux = array[i]; 
            int j = i - 1; 
            while (j >= 0 && array[j] > aux) { 
            	array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = aux; 
        }
		if(desc) {
			return array;
		} else {
			return invertirVector(array);
		}
	}
	
	/**
	 * Ordena la matriz de manera descendente por columnas
	 * @param array Matriz a ordenar
	 */
	public static void ordenaDescendentementePorColumnasTodaLaMatriz(Integer[][] array) {
		Integer[] vector = pasarDeMatrizAVector(array);
		Integer[] vectorOrdenado = ordenarVectorPorInsercion(vector, true);
		mostrarMatriz(pasarDeVectorAMatriz(vectorOrdenado, true));
	}
	
	/**
	 * Muestra la matriz triangular superior ubicada dentro de la matriz original
	 * @param array Matriz original de la cual se mostrará la matriz triangular superior
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
	 * @param array Matriz a la cual se le ordenará ascendentemente la primera columna
	 */
	public static void ordenarAscendentementePorColumna1(Integer[][] array) { //método burbuja mejorado
		Integer[] columnaOrdenada = new Integer[array.length];
		for(int i = 0 ; i < array.length; i++) {
			columnaOrdenada[i] = array[i][0];
		}
		columnaOrdenada = ordenarVectorPorBurbujaMejorado(columnaOrdenada, false);
		for(int i = 0; i < array.length; i++) {
			array[i][0] = columnaOrdenada[i];
		}
		mostrarMatriz(array);
	}
	
	/**
	 * Intercambia dos columnas de una matriz
	 * @param array Matriz a la cual se le intercambiarán las columnas
	 * @param columna1 Primera columna
	 * @param columna2 Segunda columna
	 */
	public static void intercambiarColumnas(Integer[][] array, int columna1, int columna2) {
		if(columna1 == columna2) {
			imprimirMensaje("Las columnas no pueden ser la misma");
			return;
		}
		if(columna1 <= 0 || columna2 <= 0 || columna1 > array.length || columna2 > array.length) {
			imprimirMensaje("¡ERROR! Las columnas deben estar entre 1 y " + (array.length));
			return;
		}
		imprimirMensaje("Intercambiando columnas " + columna1 + " y " + columna2);
		for(int i = 0; i < array.length; i++) {
			int aux = array[i][columna1 - 1];
			array[i][columna1 - 1] = array[i][columna2 - 1];
			array[i][columna2 - 1] = aux;
		}
		mostrarMatriz(array);
	}
	
	/**
	 * Indica si un número es primo o no
	 * @param numero Número a verificar
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
	 * Imprime los números dentro de la matriz que sean primos, y su ubicación
	 * @param array Matriz de la cual se revisarán los números primos
	 */
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
			imprimirMensaje("No hay números primos en la matriz\n");
		}
	}
	
	/**
	 * Invierte un vector
	 * @param array Vector a invertir
	 * @return El vector invertido
	 */
	public static Integer[] invertirVector(Integer[] array) {
		Integer[] newArray = new Integer[array.length]; 
        int j = array.length; 
        for (int i = 0; i < array.length; i++) { 
            newArray[j - 1] = array[i]; 
            j = j - 1; 
        } 
		return newArray;
	}
	
	/**
	 * Método general para imprimir un mensaje
	 * @param mensaje Mensaje a imprimir
	 */
	public static void imprimirMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * Método general para imprimir un mensaje sin salto de línea
	 * @param mensaje Mensaje a imprimir
	 */
	public static void imprimirSinSalto(String mensaje) {
		System.out.print(mensaje);
	}
}
