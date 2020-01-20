package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixOperationsManager {
	public static Integer[][] leerArchivo(String ruta) {
		FileReader reader = null;
		BufferedReader buffered = null;
		File file = new File(ruta);
		Integer matrixDimension = null;
		if(!file.exists()) {
			imprimirMensaje("¡El archivo especificado no existe!\n");
		} else {
			try {
				reader = new FileReader(file);
				buffered = new BufferedReader(reader);
				matrixDimension = Integer.parseInt(buffered.readLine());
			} catch (FileNotFoundException e) {
				imprimirMensaje("¡El archivo no fue encontrado!\n");
				e.printStackTrace();
			} catch (NumberFormatException e) {
				imprimirMensaje("¡Hay un dato en el archivo que no se puede convertir a número!\n");
				e.printStackTrace();
			} catch (IOException e) {
				imprimirMensaje("¡Hay un error que no sé por qué sale!\n");
				e.printStackTrace();
			}
		}
		imprimirMensaje("La dimensión de la matriz es " + matrixDimension);
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
	}
	
	public static Integer numeroMayorDeLaMatriz(Integer[][] array) {
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
	
	public static void mostrarMatriz(Integer[][] array) {
		Integer digitosMaximos = numeroMayorDeLaMatriz(array);
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
	
	public static void sumarDatos(Integer[][] array) {
		int totalSuma = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				totalSuma += array[i][j];
			}
		}
		imprimirMensaje("La suma total de datos es: " + totalSuma + "\n");
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
		imprimirMensaje("El número mayor está en la posición [" + (fila + 1) + "][" + (columna + 1) + "] con el valor " + mayor + "\n");
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
		imprimirMensaje("El número menor está en la posición [" + (fila + 1) + "][" + (columna + 1) + "] con el valor " + menor + "\n");
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
		imprimirMensaje(respuesta + "\n");
	}
	
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
			if(array[i] > mayor) {
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
		mostrarVector(respuesta, "Menor de la fila ", true);
	}
	
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
		imprimirMensaje("El promedio de la diagonal secundaria es " + promedioDiagonalSecundaria + "\n");
	}
	
	public static void ordenaDescendentementePorColumnasTodaLaMatriz(Integer[][] array) { //método de inserción
		
	}
	
	public static void mostrarPorFilasTriangularSuperiorDerecha(Integer[][] array) {
		Integer digitosMaximos = numeroMayorDeLaMatriz(array);
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
			imprimirMensaje("No hay números primos en la matriz\n");
		}
		imprimirMensaje("\n");
	}
	
	public static void imprimirMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void imprimirSinSalto(String mensaje) {
		System.out.print(mensaje);
	}
}
